package com.shuidi.uc.api.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wandy on 17-8-20.
 */
@Order(1)
@Configuration
@ConfigurationProperties(prefix = "shiro")
@PropertySource("classpath:shiro.properties")
public class ShiroFilterConfig {

  public static Map<String,String> filters = new HashMap<>();

  public static String login;
  public static String loginSuccess;
  public static String unauthorized;

  public void setFilters(Map<String, String> filter) {
    ShiroFilterConfig.filters = filter;
  }

  public Map<String, String> getFilters() {
    return filters;
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
