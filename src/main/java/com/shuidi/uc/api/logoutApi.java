package com.shuidi.uc.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.uc.api.encrypt.EncryptMD5;
import com.shuidi.uc.api.encrypt.EncryptRsa;
import com.shuidi.uc.api.shiro.LoginTools;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
@RequestMapping("logout")
public class logoutApi {

  private static final Logger log = LoggerFactory.getLogger(logoutApi.class);

  @Autowired
  private UcUserBlServie ucUserBlServie;

  @Autowired
  private RedisTemplate redisTemplate;

  private static Map keyMap;

  private static final String LOGINREDISKEY = "com.shuidi.uc.login.privateKey.";


  @RequestMapping(value = "/key", method = RequestMethod.GET)
  public Object getPrivateKey(HttpServletResponse response) throws Exception {

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
    return jsonObject;
  }

  @RequestMapping(value = {"/",""}, method = RequestMethod.GET,produces = "application/json")
  public Object login(String name, String pwd, boolean rememberMe, String keySign,HttpServletRequest request) throws Exception {

    JSONObject result = new JSONObject();
//    log.debug("准备退出的用户名是1：{}",new Object[]{(String)SecurityUtils.getSubject().getPrincipal()});
    log.debug("准备退出的用户名是2：{}",new Object[]{((UcUser)SecurityUtils.getSubject().getSession().getAttribute("userInfo")).getName()});

    LoginTools.logout();

    result.put("session",request.getSession().getId());
    result.put("status","success");
    result.put("desc","退出成功");
    return result;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public UcUser addUser(@RequestBody UcUser ucUser) throws Exception {
    ucUserBlServie.saveUcUser(ucUser);
    return ucUser;
  }


}
