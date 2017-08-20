package com.shuidi.uc.api.shiro;

import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 登录的静态工具.
 *
 * Created by wandy on 17-8-20.
 */
public class LoginTools {

  /**
   * 判断当前用户是否登录.
   *
   * @return 获取结果
   */
  public static boolean isLogin() {
    Subject currentSubject = SecurityUtils.getSubject();
    return currentSubject.getSession().getAttribute("userInfo") != null;
  }

  /**
   * 获取当前登录用户.
   *
   * @return 获取结果，获取不到则为null
   */
  public static UcUser getLonginUser() {
    Subject currentSubject = SecurityUtils.getSubject();
    Object userObj = currentSubject.getSession().getAttribute("userInfo");
    if (userObj != null) {
      return (UcUser)userObj;
    }
    return null;
  }

  /**
   * 给当前用户设置attribute.
   *
   * @param key  AttributeKey
   * @param value Object AttributeValue
   */
  public static void setAttribute(String key,Object value) {
    Subject currentSubject = SecurityUtils.getSubject();
    currentSubject.getSession().setAttribute(key,value);
  }

  /**
   * 获取当前用户的attribute.
   *
   * @param key 带获取key
   * @return 获取到的object
   */
  public static Object getAttribute(String key) {
    return SecurityUtils.getSubject().getSession().getAttribute(key);
  }

  /**
   * 获取当前用户的session.
   *
   * @return shiro session
   */
  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }
}
