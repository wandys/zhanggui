package com.shuidi.uc.api.shiro;

import com.shuidi.uc.api.UcUserApi;
import com.shuidi.uc.api.encrypt.EncryptBase64;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.annotation.Resource;

/**
 * shiro处理身份验证的核心.
 * <p>
 * Created by wandy on 17-8-17.
 */
public class ShiroRealm extends AuthorizingRealm {

  private final static Logger log = LoggerFactory.getLogger(UcUserApi.class);

  @Resource
  private UcUserBlServie ucUserBlServie;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
        * 缓存过期之后会再次执行。
        */
    System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    UcUser userInfo = (UcUser) principals.getPrimaryPrincipal();

    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
    //UserInfo userInfo = userInfoService.findByUsername(username)


    //权限单个添加;
    //或者按下面这样添加
    //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
    //authorizationInfo.addRole("admin");
    //添加权限
    //authorizationInfo.addStringPermission("userInfo:query");

    ///在认证成功之后返回.
    //设置角色信息.
    //支持 Set集合,
    //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
    // List<Role> roleList=user.getRoleList();
    //for (Role role : roleList) {
    // info.addStringPermissions(role.getPermissionsName());
    //}
    /*for(SysRole role:userInfo.getRoleList()){
      authorizationInfo.addRole(role.getRole());
      for(SysPermission p:role.getPermissions()){
        authorizationInfo.addStringPermission(p.getPermission());
      }
    }*/
    authorizationInfo.addStringPermission("/user/*");

    //设置权限信息.
    //authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()));

    return authorizationInfo;
  }

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
    System.out.println("认证登录2：name:" + phone);
    UcUser user = new UcUser();
    user.setPhone(phone);
    //通过username从数据库中查找 User对象，如果找到，没找到.
    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
    List<UcUser> users = ucUserBlServie.findUcUsers(user);
    if (users == null || users.size() <= 0) {
      throw new NullPointerException("find null user,name:" + phone);
    }
    UcUser ucUser = users.get(0);
    //将user信息放到session中
    SecurityUtils.getSubject().getSession().setAttribute("userInfo", ucUser);

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
        ucUser.getPassword(), //密码
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
