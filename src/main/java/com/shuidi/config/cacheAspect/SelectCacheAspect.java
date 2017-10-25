package com.shuidi.config.cacheAspect;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.cache.CacheKeyGeneter;
import com.shuidi.cache.CacheSelect;
import com.shuidi.cache.DataCacheType;
import com.shuidi.cache.RedisPojoUtil;
import com.shuidi.cache.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Order(10)
@Aspect
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class SelectCacheAspect {
  /*@Autowired
  private JedisPool jedisPool;*/
 /* @Autowired
  private RedisTemplate redisTemplate;*/
  @Autowired
  private RedisService redisService;

  //@Pointcut("bean(*DalService)") //切入点设置为所有以DalService结尾的bean
  @Pointcut("@annotation(com.shuidi.cache.CacheSelect)") //切入点设置为包含指定注解的方法
  //@Pointcut("execution(* com.shuidi.*.service.dal.*.*(Long))")
  public void aopCacheTarget() {
  }

  @Around("aopCacheTarget()")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    MethodSignature msig = (MethodSignature) pjp.getSignature();
    Object target = pjp.getTarget();
    Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
    DataCacheType dataCacheType = currentMethod.getAnnotation(CacheSelect.class).dataType();
    boolean clearCache = currentMethod.getAnnotation(CacheSelect.class).clearCache();
    Class[] listeners = currentMethod.getAnnotation(CacheSelect.class).listener();
    boolean cachePojo = currentMethod.getAnnotation(CacheSelect.class).cachePojo();
    String keyField = currentMethod.getAnnotation(CacheSelect.class).keyField();

    String cacheKey = CacheKeyGeneter.getKey(CacheKeyGeneter.CacheZone.TEMP, pjp.getTarget().getClass(), pjp.getSignature().getName(), pjp.getArgs());
    //String data = redisService.get(cacheKey);
    Object result;
    if (!redisService.exists(cacheKey)) {
      result = pjp.proceed();
      //加入到对应pojo的监听中
      if (clearCache) {
        Arrays.stream(listeners).forEach(listenerClz -> {
          String lisenerKey = CacheKeyGeneter.getLisenerKey(listenerClz);
          redisService.sAdd(lisenerKey, cacheKey);
        });
      }
      //缓存
      redisService.set(cacheKey, result);
    } else {
      Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
      RedisPojoUtil redisPojoUtil = new RedisPojoUtil();
      redisPojoUtil.toPojo(new HashMap<>(), returnType);
      //将获取到的字符串转换为对应对象
      String cacheResult = redisService.get(cacheKey);
      result = JSONObject.parseObject(cacheResult, returnType);
    }
    //缓存结果pojo
    if (cachePojo) {
      cachePojo(result,dataCacheType,keyField,clearCache,listeners);
    }
    return result;
  }

  /**
   * 将查询结果缓存到pojo.
   *
   * @param result        结果
   * @param dataCacheType 数据类型
   * @param keyField      主键key
   */
  private void cachePojo(Object result, DataCacheType dataCacheType, String keyField,boolean clearCache,Class[] clearListeners) {

    if (result != null) {
      List<Object> results = new ArrayList<>();
      //暂时不对map方式处理
      if (dataCacheType == DataCacheType.pojo) {
        results.add(result);
      } else if (dataCacheType == DataCacheType.list) {
        results = (List<Object>) result;
      }
      results.forEach(data -> {
        String key = CacheKeyGeneter.getPojoKey(data, keyField);
        if (!redisService.exists(key)) {
          redisService.set(key, data);
        }
        //清除缓存监听
        if (clearCache) {
          Arrays.stream(clearListeners).forEach(listenerClz -> {
            String lisenerKey = CacheKeyGeneter.getLisenerKey(listenerClz);
            redisService.sAdd(lisenerKey, key);
          });
        }
      });


    }

  }

}
