package com.shuidi.uc.api.shiro;

import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 登录的静态工具.
 *
 * Created by wandy on 17-8-20.
 */
public class LoginTools {


  public static void login(String userName,String password,boolean rememberMe) {
    if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
      throw new AccountException("账号或者密码错误");
    }

    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
    token.setRememberMe(rememberMe);
    SecurityUtils.getSubject().login(token);
  }

  public static void logout() {
    SecurityUtils.getSubject().logout();
  }

  /**
   * 判断当前用户是否登录.
   *
   * @return 获取结果
   */
  public static boolean isLogin() {
    Object currentSubject = SecurityUtils.getSubject().getSession().getAttribute("isLogin");
    return currentSubject != null && (boolean)currentSubject == true ;
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
