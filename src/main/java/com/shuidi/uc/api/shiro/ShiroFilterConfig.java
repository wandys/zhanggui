package com.shuidi.uc.api.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wandy on 17-8-20.
 */
@Configuration
@ConfigurationProperties(prefix = "shiro")
@PropertySource("classpath:shiro.properties")
public class ShiroFilterConfig {

  public static Map<String,String> filter = new HashMap<>();

  public static String login;
  public static String loginSuccess;
  public static String unauthorized;

  public void setFilter(Map<String, String> filter) {
    ShiroFilterConfig.filter = filter;
  }

  public Map<String, String> getFilter() {
    return filter;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    ShiroFilterConfig.login = login;
  }

  public String getLoginSuccess() {
    return loginSuccess;
  }

  public void setLoginSuccess(String loginSuccess) {
    ShiroFilterConfig.loginSuccess = loginSuccess;
  }

  public static String getUnauthorized() {
    return unauthorized;
  }

  public void setUnauthorized(String unauthorized) {
    ShiroFilterConfig.unauthorized = unauthorized;
  }
}
