package com.shuidi.uc.api.shiro;

import com.shuidi.uc.api.encrypt.EncryptBase64;
import com.shuidi.uc.api.encrypt.EncryptMD5;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 根据账号、密码生成加密密码，生成盐.
 * <p>
 * Created by wandy on 17-8-19.
 */
public class PassWordCreater implements PassWordSigner, SaltCreater {

  private final static Logger log = LoggerFactory.getLogger(PassWordCreater.class);

  private String userName;

  private String orginPwd;

  private String salt;

  public PassWordCreater(String userName, String orginPwd) {
    super();
    this.userName = userName;
    this.orginPwd = orginPwd;
  }

  /**
   * 加密公式： md5(base64(md5(salt + orginPwd) + salt + userName))
   *
   * @param salt 盐.
   * @return
   */
  @Override
  public String getSignedPwd(String salt) {
    //强制慢加密，防止硬破解
    try {
      TimeUnit.MICROSECONDS.sleep(500);
    } catch (InterruptedException e) {
      log.error("pwd signed time interup exp");
    }
    if (StringUtils.isBlank(salt)) {
      salt = "";
    }
    String sign = EncryptMD5.md5(salt + orginPwd);
    sign = EncryptBase64.encodeBase64(sign + salt + userName);
    sign = EncryptMD5.md5(sign);
    return sign;
  }

  /**
   * 获取salt源.
   * <p>
   * 算法描述：
   * 第一步：根据用户名、密码拼接成原始salt，
   * 第二步：然后根据salt长度的奇、偶来获取原始salt对应位置的字符拼接成第二步使用的salt
   * 第三步：根据一下公式进行计算：salt = md5(base64(secondSalt + pwd))
   * </p>
   *
   * @return
   */
  @Override
  public String creatSalt() {
    //第一步
    salt = "";
    if (StringUtils.isNotBlank(userName)) {
      salt += userName;
    }
    if (StringUtils.isNotBlank(orginPwd)) {
      salt += orginPwd;
    }
    //第二步
    char[] saltChars = salt.toCharArray();
    int index = 0;
    StringBuffer secondSaltBuffer = new StringBuffer();
    for (char c : saltChars) {
      if ((saltChars.length % 2 == 1) && (index++ % 2 == 1)) {
        secondSaltBuffer.append(c);
      } else if ((saltChars.length % 2 == 0) && (index++ % 2 == 0)) {
        secondSaltBuffer.append(c);
      }
    }
    salt = secondSaltBuffer.toString();
    //第三步
    String thirdSalt = salt + orginPwd;
    thirdSalt = EncryptBase64.encodeBase64(thirdSalt);
    salt = EncryptMD5.md5(thirdSalt);
    return salt;
  }


}
