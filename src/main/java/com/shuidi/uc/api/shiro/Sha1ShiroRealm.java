package com.shuidi.uc.api.shiro;

import com.shuidi.uc.api.encrypt.EncryptBase64;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.annotation.Resource;

/**
 * shiro处理身份验证的核心.
 * <p>校验使用sha1+salt</p>
 *
 * Created by wandy on 17-8-19.
 */
public class Sha1ShiroRealm extends ShiroRealm {

  private final static Logger log = LoggerFactory.getLogger(Sha1ShiroRealm.class);

  @Resource
  private UcUserBlServie ucUserBlServie;

  /**
   * 认证信息.(身份验证)
   * :
   * Authentication 是用来验证用户身份
   *
   * @param token
   * @return
   * @throws AuthenticationException
   */

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    //获取用户的输入的账号.
    String phone = (String) token.getPrincipal();
    System.out.println("认证登录：name:"+phone+",pwd:");
    UcUser user = new UcUser();
    user.setPhone(phone);
    //通过username从数据库中查找 User对象，如果找到，没找到.
    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
    List<UcUser> users = ucUserBlServie.findUcUsers(user);
    if (users == null || users.size() <= 0) {
      throw new NullPointerException("find null user,name:" + phone);
    }
    UcUser ucUser = users.get(0);

       /*
        * 获取权限信息:这里没有进行实现，
        * 请自行根据UserInfo,Role,Permission进行实现；
        * 获取之后可以在前端for循环显示所有链接;
        */
    //userInfo.setPermissions(userService.findPermissions(user));

    //账号判断;
    //加密方式;
    //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        ucUser, //用户名
        EncryptBase64.encodeBase64(ucUser.getPassword()), //密码
        //ByteSource.Util.bytes(ucUser.getCredentialsSalt()),//salt=username+salt
        getName()  //realm name
    );

    //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//           userInfo, //用户名
//           userInfo.getPassword(), //密码
//             getName()  //realm name
//      );

    return authenticationInfo;
  }
}
