package com.shuidi.uc.api.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * normal single resource.
 *
 * Created by wandy on 17-8-21.
 */
public class SingleResource<T> extends ResourceSupport {

  private T data;

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
}
