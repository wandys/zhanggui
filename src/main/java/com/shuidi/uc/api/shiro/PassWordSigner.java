package com.shuidi.uc.api.shiro;

/**
 * 密码签名器.
 *
 * Created by wandy on 17-8-19.
 */
public interface PassWordSigner {

  /**
   * 获取签名之后的密码.
   *
   * @return 加密签名结果
   */
  public String getSignedPwd(String salt);
}
