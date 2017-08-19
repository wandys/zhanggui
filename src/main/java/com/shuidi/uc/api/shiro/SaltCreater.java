package com.shuidi.uc.api.shiro;

/**
 * salt生成器.
 *
 * Created by wandy on 17-8-19.
 */
public interface SaltCreater {

  /**
   * 获取salt.
   */
  public String creatSalt();
}
