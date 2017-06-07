package com.shuidi.uc.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.uc.api.encrypt.Rsa;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

    private static Map keyMap;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Object getPrivateKey(HttpServletResponse response) throws Exception {

        keyMap = Rsa.initKey();
        log.info(Rsa.getPublicKey(keyMap));
        //OutputStream outputStream = response.getOutputStream();
        //outputStream.write(Rsa.getPublicKey(keyMap).getBytes());
        //outputStream.close();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("publicKey",Rsa.getPublicKey(keyMap).getBytes());
        return jsonObject;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String login(String name,String pwd,boolean rememberMe) throws Exception {
        UcUser user = new UcUser();
        user.setName(name);
        pwd = Rsa.unEncrypt(Rsa.getPrivateKey(keyMap),pwd);
        List<UcUser> userResult = ucUserBlServie.findUcUsers(user);
        if (userResult.size() <= 0 || !userResult.get(0).getPassword().equals(Rsa.unEncrypt(Rsa.getPrivateKey(keyMap),pwd))) {
            return "账号或者密码错误";
        }
        return "登陆成功！";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public UcUser addUser(@RequestBody UcUser ucUser) throws Exception {
        return ucUser;
    }
}
