package com.shuidi.commons.resource;

import com.shuidi.commons.enums.State;
import com.shuidi.uc.commons.enums.Status;
import org.springframework.hateoas.ResourceSupport;

/**
 * 不带有任何数据.
 *
 * Created by wandy on 17-8-21.
 */
public class OnlyResource extends ResourceSupport implements BaseResource {

  private State status;

  private String desc;

  private String code;

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
