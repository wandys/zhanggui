package com.shuidi.config;

import com.shuidi.uc.api.shiro.ShiroFilterConfig;
import com.shuidi.uc.api.shiro.ShiroRealm;
import com.shuidi.uc.api.shiro.ShuidiCredentialsMatcher;
import com.shuidi.uc.api.shiro.redis.RedisCacheManager;
import com.shuidi.uc.api.shiro.redis.RedisSessionDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置
 * <p>
 * Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。
 * 既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。
 * <p>
 * Created by wandy on 17-8-17.
 */


@Configuration
public class ShiroConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

  //@Autowired
  //private ShiroFilterConfig shiroFilterConfig;

  /**
   * ShiroFilterFactoryBean 处理拦截资源文件问题。
   * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
   * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
   * <p>
   * Filter Chain定义说明
   * 1、一个URL可以配置多个Filter，使用逗号分隔
   * 2、当设置多个过滤器时，全部验证通过，才视为通过
   * 3、部分过滤器可指定参数，如perms，roles
   */


  @Bean
  @Order(2)
  public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager,ShiroFilterConfig shiroFilterConfig) {
    logger.debug("ShiroConfiguration.shirFilter()");
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

    // 必须设置 SecurityManager
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    //拦截器.
    /*Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");

    //<!-- 过滤链定义，从上向下顺序执行，将/×*放在最为下边,否则配置的不需要权限的验证链接则不会生效 -->
    //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    //配置这个作为不需要授权访问的地址做测试
    filterChainDefinitionMap.put("/login/key", "anon");
    filterChainDefinitionMap.put("/login/", "anon");
    //配置需要登录才能访问链接
    //filterChainDefinitionMap.put("/logout/key", "user");
    //需要授权地址配置
    filterChainDefinitionMap.put("*//**", "authc");

    //如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
    shiroFilterFactoryBean.setLoginUrl("/login");
    // 登录成功后要跳转的链接
    shiroFilterFactoryBean.setSuccessUrl("/index");
    //未授权界面;
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");*/
    // shiroFilterFactoryBean.setUnauthorizedUrl("/login/key");
    //如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
    shiroFilterFactoryBean.setLoginUrl(ShiroFilterConfig.login);
    // 登录成功后要跳转的链接
    shiroFilterFactoryBean.setSuccessUrl(ShiroFilterConfig.loginSuccess);
    //<!-- 过滤链定义，从上向下顺序执行，将/×*放在最为下边,否则配置的不需要权限的验证链接则不会生效 -->
    //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    //配置这个作为不需要授权访问的地址做测试
    Map<String, String> filterChainDefinitionMap = shiroFilterConfig.getFilters();

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }


  @Bean
  public SecurityManager securityManager(RedisSessionDAO redisSessionDAO) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setSessionManager(sessionManager(redisSessionDAO));
    securityManager.setCacheManager(redisCacheManager());    //将自定义realm注入到sercurityManager.
    securityManager.setRealm(myShiroRealm());
    return securityManager;
  }

  @Bean
  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public RedisCacheManager redisCacheManager() {
    return new RedisCacheManager();
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(RedisSessionDAO redisSessionDAO) {
    AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
    aasa.setSecurityManager(securityManager(redisSessionDAO));
    return new AuthorizationAttributeSourceAdvisor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
    daap.setProxyTargetClass(true);
    return daap;
  }

  @Bean
  public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    sessionManager.setSessionDAO(redisSessionDAO);
    sessionManager.setGlobalSessionTimeout(1000*60*60*24*30);
    sessionManager.setCacheManager(redisCacheManager());
    //单独设置cookie有效时间
    /*SimpleCookie cookie = new SimpleCookie();
    cookie.setName("logincookie");
    cookie.setMaxAge(1000*60*60*24*30);
    sessionManager.setSessionIdCookie(cookie);*/
    return sessionManager;
  }
  /**
   * 注入自定义的身份认证realm;
   * (这个需要自己写，账号密码校验；权限等)
   *
   * @return
   */

  @Bean
  public ShiroRealm myShiroRealm() {
    ShiroRealm myShiroRealm = new ShiroRealm();
    //添加密码验证
    myShiroRealm.setCredentialsMatcher(allowAllCredentialsMatcher());
    return myShiroRealm;
  }

  /**
   * 凭证匹配器
   * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
   * 所以我们需要修改下doGetAuthenticationInfo中的代码;
   * ）
   *
   * @return
   */

  @Bean
  public ShuidiCredentialsMatcher allowAllCredentialsMatcher() {

    ShuidiCredentialsMatcher matcher = new ShuidiCredentialsMatcher();
    return matcher;
  }

}
