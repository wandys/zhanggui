package com.shuidi.commons.exception;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.enums.State;
import com.shuidi.commons.resource.OnlyResource;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.data.rest.webmvc.support.BaseUriLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.LinkBuilderFactory;
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilderFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.WebUtils;

/**
 * global rest exception handler.
 * this handler will catch everyone exception which method with {@RequestMapping } annotation.
 *
 * Created by wandy on 17-8-21.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                           HttpHeaders headers, HttpStatus status, WebRequest request) {

    if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
      request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
    }

    OnlyResource resource = new OnlyResource();
    resource.setCode(String.valueOf(status.value()));
    resource.setDesc(ex.getMessage());
    resource.setStatus(State.FAILED);
    //LinkBuilder linkBuilder = new BaseUriLinkBuilder(ServletUriComponentsBuilder.fromRequest(request));
    LinkBuilder linkBuilder = new BaseUriLinkBuilder(UriComponentsBuilder.fromPath(((ServletWebRequest)request).getRequest().getRequestURL().toString()));
    Link link = linkBuilder.withSelfRel();
    resource.add(link);
    //result.put("test",((ServletWebRequest)request).getRequest().getRequestURI());
    return new ResponseEntity<Object>(resource, headers, status);
  }

  /**
   * 处理自定义异常.
   *
   * @param ex 异常信息
   * @param request 请求
   * @return
   */
  @ExceptionHandler({
      ServiceException.class,
      CheckedException.class
  })
  public final ResponseEntity<Object> handleSelfException(Exception ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    if (ex instanceof ServiceException) {
      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      String body = "service error";
      return handleExceptionInternal( ex,body, headers, status, request);
    }
    else if (ex instanceof CheckedException) {
      String body = "service params valid error";
      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      return handleExceptionInternal(ex,body, headers, status, request);
    }

    else {
      if (logger.isWarnEnabled()) {
        logger.warn("Unknown exception type: " + ex.getClass().getName());
      }
      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      return handleExceptionInternal(ex, null, headers, status, request);
    }
  }
}
