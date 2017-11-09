package com.shuidi.commons.resource;

import com.shuidi.commons.enums.State;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * normal list resource，通用resource
 * <p>
 * Created by wandy on 17-8-21.
 */
public class CollectsResource<T> extends ResourceSupport implements BaseResource {

  private List<T> data;

  private State status;

  private String desc;

  private String code;

  public CollectsResource() {
    this.data = null;
  }

  public CollectsResource(T data) {
    List<T> datas = new ArrayList<>();
    datas.add(data);
    this.data = datas;
  }

  public static <T> CollectsResource resource(T data) {

    return new CollectsResource(data);
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
