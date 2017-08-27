package com.shuidi.uc.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.uc.api.shiro.LoginTools;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-05-30.
 * Change Time 2017-05-30 23:23.
 */
@RestController
@RequestMapping("logout")
@ExposesResourceFor(logoutApi.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class logoutApi {

  private static final Logger log = LoggerFactory.getLogger(logoutApi.class);

  @Autowired
  private EntityLinks entityLinks;

  @RequestMapping(value = {"/",""}, method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity login(String name, String pwd, boolean rememberMe, String keySign, HttpServletRequest request) throws Exception {

    JSONObject result = new JSONObject();
    log.debug("准备退出的用户名是2：{}",new Object[]{((UcUser)SecurityUtils.getSubject().getSession().getAttribute("userInfo")).getName()});
    LoginTools.logout();
    result.put("session",request.getSession().getId());
    result.put("status","success");
    result.put("desc","退出成功");
    SingleResource<JSONObject> resource = new SingleResource(result);
    return ResponseEntity.ok(resource);
  }
}
