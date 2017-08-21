package com.shuidi.uc.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.uc.api.encrypt.EncryptMD5;
import com.shuidi.uc.api.encrypt.EncryptRsa;
import com.shuidi.uc.api.resource.OnlyResource;
import com.shuidi.uc.api.resource.SingleResource;
import com.shuidi.uc.api.shiro.LoginTools;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("login")
@ExposesResourceFor(loginApi.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class loginApi {

  private static final Logger log = LoggerFactory.getLogger(loginApi.class);

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private EntityLinks entityLinks;

  private static Map keyMap;

  private static final String LOGINREDISKEY = "com.shuidi.uc.login.privateKey.";


  @RequestMapping(value = "/key", method = RequestMethod.GET)
  public ResponseEntity getPrivateKey(HttpServletResponse response) throws Exception {

    keyMap = EncryptRsa.initKey();
    log.info(EncryptRsa.getPublicKey(keyMap));
    String privateKeySign = EncryptMD5.md5(EncryptRsa.getPrivateKey(keyMap));
    //todo 将生成的结果privateKey 存放到redis当中
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    valueOperations.set(LOGINREDISKEY + privateKeySign, EncryptRsa.getPrivateKey(keyMap), 12, TimeUnit.HOURS);

    String publicKey = EncryptRsa.getPublicKey(keyMap);
    Pattern p = Pattern.compile("\n");
    Matcher m = p.matcher(publicKey);
    publicKey = m.replaceAll("");

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("publicKey", publicKey);
    jsonObject.put("publicKeySign", privateKeySign);
    //jsonObject.put("privateKey", valueOperations.get(LOGINREDISKEY + privateKeySign));

    SingleResource<JSONObject> resource = new SingleResource(jsonObject);
    Link link = entityLinks.linkToSingleResource(loginApi.class,null);
    resource.add(link);
    return ResponseEntity.ok(resource);
  }

  @RequestMapping(value = {"/",""}, method = RequestMethod.POST,produces = "application/json")
  public ResponseEntity login(@RequestBody JSONObject loginData, HttpServletRequest request) throws Exception {

    String phone = loginData.getString("phone");
    String pwd = loginData.getString("password");
    //boolean rememberMe = loginData.getBoolean("rememberMe");
    //从缓存中获取对应的privilateKey
   /* ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    String privilateKey = valueOperations.get(LOGINREDISKEY + keySign);
    if (StringUtils.isBlank(privilateKey)) {
      return "key过期，请重新获取key";
    }
    ShiroFilterConfig.filters.entrySet().stream().forEach(entry ->{
      log.info("shiro filters key:{},value:{}",new Object[]{entry.getKey(),entry.getValue()});
    });*/
    JSONObject result = new JSONObject();
    SingleResource<JSONObject> resource = new SingleResource(result);
    if (LoginTools.isLogin()) {
      result.put("session",request.getSession().getId());
      result.put("status","success");
      result.put("desc","您已经登录，无需再次登录！");
      return ResponseEntity.ok(resource);
    }
    try {
     LoginTools.login(phone,pwd,true);
     LoginTools.setAttribute("isLogin",true);
    } catch (Exception e) {
      LoginTools.setAttribute("isLogin",false);
      result.put("status","failed");
      result.put("desc","账号或者密码错误");
      return ResponseEntity.badRequest().body(resource);
    }
    result.put("session",request.getSession().getId());
    result.put("status","success");
    result.put("desc","登录成功");
    return ResponseEntity.ok(resource);
  }
}
