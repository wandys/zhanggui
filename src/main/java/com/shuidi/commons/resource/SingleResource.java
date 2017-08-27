package com.shuidi.commons.resource;

import com.shuidi.commons.enums.State;
import org.springframework.hateoas.ResourceSupport;

/**
 * normal single resource.
 * <p>
 * Created by wandy on 17-8-21.
 */
public class SingleResource<T> extends ResourceSupport implements BaseResource {

  private T data;

  private State status;

  private String desc;

  private String code;

  public SingleResource() {
    this.data = null;
  }

  public SingleResource(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public State getStatus() {
    return status;
  }

  public void setStatus(State status) {
    this.status = status;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
