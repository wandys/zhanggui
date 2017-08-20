package com.shuidi.uc.api;

import com.shuidi.commons.exception.CheckedException;
import com.shuidi.uc.api.resource.UcUserResource;
import com.shuidi.uc.api.shiro.PassWordCreater;
import com.shuidi.uc.commons.enums.Status;
import com.shuidi.uc.commons.utils.UserCheckerUtil;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * ucUser api  返回rest风格json
 * <p>
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 19:50.
 */
@RestController
@RequestMapping(value = "/user")
@ExposesResourceFor(UcUser.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class UcUserApi {

  private final static Logger log = LoggerFactory.getLogger(UcUserApi.class);

  @Autowired
  private UcUserBlServie ucUserBlServie;

  @Autowired
  private EntityLinks entityLinks;


  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity getUser(@PathVariable Long id) {
    try {
      UcUser ucUser = ucUserBlServie.getUserById(id);
      UcUserResource resource = new UcUserResource(ucUser);
      Link selfLink = entityLinks.linkToSingleResource(UcUser.class, id);
      Link basesLink = entityLinks.linkToCollectionResource(UcUser.class).withRel("collects");
      //Link trucksLink = linkTo(methodOn(this.getClass()).findUcUsers()).withRel("aa");
      resource.add(selfLink, basesLink);
      return ResponseEntity.ok().body(resource);

    } catch (Exception e) {
      log.error("", e);
      return ResponseEntity.status(500).body(e);
    }
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity findUcUsers(@RequestBody UcUser user) {
    try {
      List<UcUser> ucUser = ucUserBlServie.findUcUsers(user);
      UcUserResource resource = new UcUserResource(ucUser);
      Link selfLink = entityLinks.linkToSingleResource(UcUser.class, "${id}");
      Link basesLink = entityLinks.linkToCollectionResource(UcUser.class).withRel("collects");
      Link trucksLink = linkTo(methodOn(this.getClass()).findUcUsers(user)).withRel("aa");
      resource.add(selfLink, basesLink, trucksLink);
      return ResponseEntity.ok().body(resource);

    } catch (Exception e) {
      log.error("", e);
      return ResponseEntity.badRequest().body(e);
    }
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ResponseEntity saveUcUsers(@RequestBody UcUser user) {
    try {
      if (!UserCheckerUtil.isPhone(user.getPhone())) {
        throw new CheckedException("user phone check error");
      }
      UcUser searchUser = new UcUser();
      searchUser.setPhone(user.getPhone());
      List<UcUser> ucUsers = ucUserBlServie.findUcUsers(searchUser);
      if (ucUsers != null && ucUsers.size() != 0) {
        throw new CheckedException("user had exist");
      }
      user.setUpdateTime(new Date());
      user.setCreateTime(new Date());
      user.setStatus(Status.ENABLED);
      if (StringUtils.isBlank(user.getPassword())) {
        user.setPassword("123456");
      }
      //加密密码
      PassWordCreater creater = new PassWordCreater(user.getPhone(), user.getPassword());
      user.setPassword(creater.getSignedPwd(creater.creatSalt()));

      Long userId = ucUserBlServie.saveUcUser(user);
      UcUserResource resource = new UcUserResource();
      Link selfLink = entityLinks.linkToSingleResource(UcUser.class, userId);
      resource.add(selfLink);
      return ResponseEntity.ok().body(resource);

    } catch (Exception e) {
      log.error("", e);
      return ResponseEntity.badRequest().body(e);
    }
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public ResponseEntity updateUcUsers(@RequestBody UcUser user) {
    try {
      ucUserBlServie.updateUcUser(user);
      UcUserResource resource = new UcUserResource();
      Link selfLink = entityLinks.linkToSingleResource(UcUser.class, user.getId());
      resource.add(selfLink);
      return ResponseEntity.ok().body(resource);

    } catch (Exception e) {
      log.error("", e);
      return ResponseEntity.badRequest().body(e);
    }
  }

  @RequestMapping(value = "/exist", method = RequestMethod.POST)
  public void checkUser(UcUser ucUser) {


  }
}
