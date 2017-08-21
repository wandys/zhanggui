package com.shuidi.uc.api.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * s
 * normal list resource，通用resource
 * <p>
 * Created by wandy on 17-8-21.
 */
public class CollectsResource<T> extends ResourceSupport {

  private List<T> data;

  public CollectsResource() {
    this.data = null;
  }

  public CollectsResource(T data) {
    List<T> datas = new ArrayList<>();
    datas.add(data);
    this.data = datas;
  }

  public CollectsResource(List<T> data) {
    this.data = data;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
