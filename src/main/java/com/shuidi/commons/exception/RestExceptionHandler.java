package com.shuidi.commons.exception;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.enums.State;
import com.shuidi.commons.resource.OnlyResource;
import org.springframework.data.rest.webmvc.support.BaseUriLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.LinkBuilderFactory;
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilderFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
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
}
