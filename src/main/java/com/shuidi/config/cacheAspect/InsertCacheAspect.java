package com.shuidi.config.cacheAspect;

import com.shuidi.cache.CacheInsert;
import com.shuidi.cache.CacheKeyGeneter;
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
import java.util.List;
import java.util.Map;

@Order(10)
@Aspect
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class InsertCacheAspect {
  /*@Autowired
  private JedisPool jedisPool;*/
 /* @Autowired
  private RedisTemplate redisTemplate;*/
  @Autowired
  private RedisService redisService;

  //@Pointcut("bean(*DalService)") //切入点设置为所有以DalService结尾的bean
  @Pointcut("@annotation(com.shuidi.cache.CacheInsert)") //切入点设置为包含指定注解的方法
  //@Pointcut("execution(* com.shuidi.*.service.dal.*.*(Long))")
  public void aopCacheTarget() {
  }

  @Around("aopCacheTarget()")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

    Object result = pjp.proceed();
    //获取接口类上面的注解
    //Method method = ((MethodSignature) pjp.getSignature()).getMethod();
    //获取实现类上面的注解
    MethodSignature msig = (MethodSignature) pjp.getSignature();
    Object target = pjp.getTarget();
    Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
    DataCacheType dataCacheType = currentMethod.getAnnotation(CacheInsert.class).dataType();
    String field = currentMethod.getAnnotation(CacheInsert.class).keyField();
    List<Object> datas = new ArrayList<>();
    Object[] args = pjp.getArgs();
    //当前对map类型的数据暂时无法处理
    if (dataCacheType == DataCacheType.pojo) {
      if (args.length > 0 && args.length <= 1) {
        datas.add(args[0]);
      }
    } else if (dataCacheType == DataCacheType.list) {
      if (args.length > 0 && args.length <= 1) {
        datas = Arrays.asList(args);
      }
    }
    if (datas.size() >= 1) {
      saveCacheData(datas, field);
    }
    return result;


  }

  /**
   * 保存数据到缓存中.
   *
   * @param datas 数据
   */
  private void saveCacheData(List<Object> datas, String field) {
    datas.forEach(data -> {
      //Class dataClass = data.getClass();
      String cacheKey = CacheKeyGeneter.getPojoKey(data, field);
      RedisPojoUtil pojoUtil = new RedisPojoUtil();
      Map<String, String> dataMap = pojoUtil.toMap(data);
      dataMap.entrySet().forEach(entry -> {
        redisService.setMap(cacheKey, entry.getKey(), entry.getValue());
      });
    });
  }

}
