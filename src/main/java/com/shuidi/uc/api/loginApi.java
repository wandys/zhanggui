package com.shuidi.uc.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.uc.api.encrypt.EncryptMD5;
import com.shuidi.uc.api.encrypt.EncryptRsa;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class loginApi {

  private static final Logger log = Logger.getLogger(loginApi.class);

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

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String login(String name, String pwd, boolean rememberMe,String keySign) throws Exception {
    //从缓存中获取对应的privilateKey
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    String privilateKey = valueOperations.get(LOGINREDISKEY + keySign);
    if (StringUtils.isBlank(privilateKey)) {
      return "key过期，请重新获取key";
    }

    UcUser user = new UcUser();
    user.setName(name);
    pwd = EncryptRsa.unEncrypt(privilateKey, pwd);
    List<UcUser> userResult = ucUserBlServie.findUcUsers(user);
    if (userResult.size() <= 0 || !userResult.get(0).getPassword().equals(EncryptRsa.unEncrypt(EncryptRsa.getPrivateKey(keyMap), pwd))) {
      return "账号或者密码错误";
    }
    return "登陆成功！";
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public UcUser addUser(@RequestBody UcUser ucUser) throws Exception {
    return ucUser;
  }
}
