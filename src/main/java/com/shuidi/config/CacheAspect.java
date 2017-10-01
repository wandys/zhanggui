package com.shuidi.config;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.cache.CacheKeyGeneter;
import com.shuidi.cache.RedisPojoUtil;
import com.shuidi.cache.RedisService;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

@Order(10)
@Aspect
@Configuration
@EnableAspectJAutoProxy(exposeProxy=true)
public class CacheAspect {
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

    String cacheKey = CacheKeyGeneter.getKey(CacheKeyGeneter.CacheZone.TEMP, pjp.getTarget().getClass(),pjp.getSignature().getName(), pjp.getArgs());
    //String data = redisService.get(cacheKey);
    if (!redisService.exists(cacheKey)) {
      Object result = pjp.proceed();
      redisService.set(cacheKey, result);
      return result;
    } else {
      Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
      RedisPojoUtil redisPojoUtil = new RedisPojoUtil();
      redisPojoUtil.toPojo(new HashMap<>(),returnType);
      return redisService.get(cacheKey);
    }
    /*System.out.print("。。。。。。。。。。。。。。。。。。。。。。。。。。。");
    return pjp.getArgs();*                                                                                                                                                                                                                                                                                                                                                                                                              /
    /*String targetName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();
    try {
      Class targetClass = Class.forName(targetName);
      Method[] methods = targetClass.getMethods();
      DataCacheType dataCacheType;
      for (Method method : methods) {
        if (method.getName().equals(methodName)) {
          Class[] clazzs = method.getParameterTypes();
          if (clazzs.length == arguments.length) {
            dataCacheType = method.getAnnotation(CacheSelect.class).dataType();
            break;
          }
        }
      }
      String cacheKey = CacheKeyGeneter.getKey(CacheKeyGeneter.CacheZone.TEMP, this.getClass(), arguments);
      String data = jedisPool.getResource().get(cacheKey);
      if (StringUtils.isBlank(data)) {
        Object result = pjp.proceed();
        jedisPool.getResource().set(cacheKey, JSONObject.toJSONString(result));
        return result;
      } else {
        return data;
      }

    } catch (Exception e) {
      return null;
    } catch (Throwable throwable) {
      return null;
    }*/
  }

}
