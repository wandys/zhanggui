package com.shuidi.uc.api.shiro;

import com.shuidi.uc.service.dal.entity.UcUser;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密码校验.
 * <p>
 * Created by wandy on 17-8-19.
 */
public class ShuidiCredentialsMatcher implements CredentialsMatcher {

  private static final Logger log = LoggerFactory.getLogger(SimpleCredentialsMatcher.class);


  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    //待验证的用户名，即dologin 放入的用户名和密码
    String user = (String) token.getPrincipal();
    String pwd = new String((char[])token.getCredentials());
    PassWordCreater passWordSigner = new PassWordCreater(user,pwd);
    pwd = passWordSigner.getSignedPwd(passWordSigner.creatSalt());

    //realm中查询到的用户密码
    SimpleAuthenticationInfo simpleAuthenticationInfo = (SimpleAuthenticationInfo)info;
    String pwdInfo = (String) simpleAuthenticationInfo.getCredentials();
    PrincipalCollection userNameCollection = simpleAuthenticationInfo.getPrincipals();

    UcUser userNameInfo = (UcUser) userNameCollection.getPrimaryPrincipal();
    log.debug("oriName:{},oriPwd:{},infoName:{},infoPwd:{}", new Object[]{user, pwd, userNameInfo.getPhone(),pwdInfo});
    if (pwd.equals(pwdInfo)) {
      return true;
    }
    return false;
  }
}
