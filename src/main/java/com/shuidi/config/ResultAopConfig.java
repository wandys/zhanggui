package com.shuidi.config;

import com.shuidi.commons.enums.State;
import com.shuidi.commons.resource.BaseResource;
import com.shuidi.uc.api.loginApi;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;

/**
 * Created by wandy on 17-8-28.
 */
@Order(102)
@Aspect
@Configuration
public class ResultAopConfig {

  private static final Logger log = LoggerFactory.getLogger(ResultAopConfig.class);

  @Pointcut("execution(* com.shuidi.*.api.*.*(..))")
  public void aopTarget() {
  }

  @Around("aopTarget()")
  public Object doAround( ProceedingJoinPoint pjp) throws Throwable {
    Object result = pjp.proceed();
    if(result instanceof ResponseEntity){
      ResponseEntity responseEntity = (ResponseEntity)result;
      Object body = responseEntity.getBody();
      if (responseEntity.getBody() instanceof BaseResource) {
        BaseResource resource = (BaseResource) body;
        resource.setCode(String.valueOf(responseEntity.getStatusCode().value()));
        resource.setStatus(State.SUCCESS);
        resource.setDesc(State.SUCCESS.name());
      }
    }
    return result;
  }
}
