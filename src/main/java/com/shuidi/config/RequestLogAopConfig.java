package com.shuidi.config;

import com.alibaba.fastjson.JSON;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.OnlyResource;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.uc.api.shiro.LoginTools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wandy on 17-8-28.
 */
@Order(101)
@Aspect
@Configuration
public class RequestLogAopConfig {

  private static final Logger log = LoggerFactory.getLogger(RequestLogAopConfig.class);

  private Long startMills;

  private Long endMills;

  private String resultStr;

  private String requestStr;

  @Pointcut("execution(* com.shuidi.*.api.*.*(..))")
  public void logAopTarget() {

  }

  @Before("logAopTarget()")
  public void doLogBefore(JoinPoint joinPoint) {
    startMills = System.currentTimeMillis(); // 记录方法开始执行的时间
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    HttpServletRequest request = sra.getRequest();

    String url = request.getRequestURL().toString();
    String method = request.getMethod();
    String uri = request.getRequestURI();
    String queryString = request.getQueryString();
    String loginUser = "none";
    if (LoginTools.isLogin()) {
      loginUser = LoginTools.getLonginUser().getPhone();
    }
    // 获取输入参数
    StringBuffer paramsBuffer = new StringBuffer();
    if (method.equals("GET")) {
      paramsBuffer.append(queryString);
    } else {
      Map<String, String[]> inputParamMap = request.getParameterMap();
      for (Map.Entry<String,String[]> entry : inputParamMap.entrySet()) {
        for (String value : entry.getValue()) {
          paramsBuffer.append(entry.getKey()).append("=").append(value).append("&");
        }
      }
    }

    StringBuffer requestBuffer = new StringBuffer();
    requestBuffer.append("url:" + url)
        .append(",method:" + method)
        .append(",loginUser:" + loginUser)
        //.append(",uri:" + uri)
        .append(",params:" + paramsBuffer.toString());
        //.append(",inputParamMap:" + inputParamMap);
    requestStr = requestBuffer.toString();
  }

  @Around("logAopTarget()")
  public Object doLogAround(ProceedingJoinPoint pjp) throws Throwable {
    log.debug("come in aop do around");
    Object result = pjp.proceed();
    if (result instanceof ResponseEntity) {
      ResponseEntity responseEntity = (ResponseEntity) result;
      Object body = responseEntity.getBody();
      if (body instanceof SingleResource) {
        SingleResource singleResource = (SingleResource) body;
        resultStr = JSON.toJSONString(singleResource);
      } else if (body instanceof CollectsResource) {
        CollectsResource collectsResource = (CollectsResource) body;
        resultStr = JSON.toJSONString(collectsResource);
      } else if (body instanceof OnlyResource) {
        OnlyResource onlyResource = (OnlyResource) body;
        resultStr = JSON.toJSONString(onlyResource);
      } else {
        resultStr = JSON.toJSONString(body);
      }
    }
    return result;
  }

  @After("logAopTarget()")
  public void doLogAfter() {
    endMills = System.currentTimeMillis(); // 记录方法开始执行的时间
    log.info("requst info:{},result info:{},cost:{} ms", new Object[]{requestStr, resultStr, endMills - startMills});
  }
}
