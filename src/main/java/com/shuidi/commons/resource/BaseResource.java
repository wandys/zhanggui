package com.shuidi.commons.resource;

import com.shuidi.commons.enums.State;

/**
 * Created by wandy on 17-8-24.
 */

public interface BaseResource {


  public String getCode();

  public void setCode(String code);

  public State getStatus();

  public void setStatus(State status);

  public String getDesc();

  public void setDesc(String desc);

}
