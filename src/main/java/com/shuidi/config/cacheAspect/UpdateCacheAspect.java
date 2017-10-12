package com.shuidi.config.cacheAspect;

import com.shuidi.cache.CacheKeyGeneter;
import com.shuidi.cache.CacheUpdate;
import com.shuidi.cache.DataCacheType;
import com.shuidi.cache.PojoCompareResult;
import com.shuidi.cache.PojoCompareUtil;
import com.shuidi.cache.RedisPojoUtil;
import com.shuidi.cache.RedisService;
import com.shuidi.commons.exception.ServiceException;
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
public class UpdateCacheAspect {

  @Autowired
  private RedisService redisService;

  @Pointcut("@annotation(com.shuidi.cache.CacheUpdate)") //切入点设置为包含指定注解的方法
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
    DataCacheType dataCacheType = currentMethod.getAnnotation(CacheUpdate.class).dataType();
    String field = currentMethod.getAnnotation(CacheUpdate.class).keyField();
    boolean clearCache = currentMethod.getAnnotation(CacheUpdate.class).clearCache();
    Class[] listeners = currentMethod.getAnnotation(CacheUpdate.class).listener();
    List<Object> datas = new ArrayList<>();
    Object[] args = pjp.getArgs();
    //当前对map类型的数据暂时无法处理
    if (dataCacheType == DataCacheType.pojo) {
      if (args.length > 0 || args.length <= 1) {
        datas.add(args[0]);
      }
    } else if (dataCacheType == DataCacheType.list) {
      if (args.length > 0 || args.length <= 1) {
        datas = Arrays.asList(args);
      }
    }
    if (datas.size() >= 1) {
      updateCacheData(datas, field);
      //清除缓存信息.
      if (clearCache) {
        clearCacheData(listeners);
      }
    }
    return result;


  }

  /**
   * 保存数据到缓存中.
   *
   * @param datas 数据
   */
  private void updateCacheData(List<Object> datas, String field) {
    datas.forEach(data -> {
      try {
        String cacheKey = CacheKeyGeneter.getPojoKey(data, field);
        Object cacheData = RedisPojoUtil.toPojo(redisService.getMap(cacheKey), data.getClass());
        if (cacheData != null) {
          List<PojoCompareResult> compareResults = PojoCompareUtil.compare(cacheData, data, PojoCompareUtil.CompareFeature.StringEmptyAsNull);
          Map<String, String> newDataMap = RedisPojoUtil.toMap(data);
          compareResults.forEach(compareResult ->
              redisService.setMap(cacheKey, compareResult.getFieldName(), newDataMap.get(compareResult.getFieldName()))
          );
        } /*else {
        //todo 暂时不考虑重新缓存,放到查询时候处理
          //重新保存对象
          Map<String, String> stringMap = RedisPojoUtil.toMap(data);
          stringMap.entrySet().forEach(entry -> redisService.setMap(cacheKey, entry.getKey(), entry.getValue()));
        }*/
      } catch (Exception e) {
        throw new ServiceException("pojo paras error", e);
      }
    });
  }

  /**
   * 清除缓存的信息.
   *
   * @param listeners 监听类
   */
  private void clearCacheData(Class[] listeners) {

    Arrays.stream(listeners).forEach(aClass -> {
      String lisenerKey = CacheKeyGeneter.getLisenerKey(aClass);
      List<String> cacheKeys = redisService.sMembers(lisenerKey);
      cacheKeys.forEach(cacheKey -> redisService.sRem(lisenerKey, cacheKey));
    });
  }

}
