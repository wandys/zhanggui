/*
 * Created by wandy on 2016-11-10.
 */

package com.shuidi.uc.api.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5编码工具类.
 *
 * <p>支持大小写、和不同编码格式的MD5.
 * 默认为UTF-8 、小写</p>
 *
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2016-11-10
 */
public class EncryptMD5 {
  private static final String CHARACTER_SET = "UTF-8";

  public EncryptMD5() {
  }

  public static final String md5(String str) {
    return md5(str, "UTF-8");
  }

  /**
   * 带编码格式的md5方法.
   *
   * @param input 输入待编码字符创
   * @param characterSet  编码格式
   *
   * @return  返回编码结果
   */
  public static final String md5(String input, String characterSet) {
    char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    MessageDigest mdTemp = null;
    byte[] strTemp;
    try {
      strTemp = input.getBytes(characterSet);
      mdTemp = MessageDigest.getInstance("MD5");
    } catch (UnsupportedEncodingException unSupport) {
      throw new RuntimeException(unSupport);
    } catch (NoSuchAlgorithmException noSuch) {
      throw new RuntimeException(noSuch);
    }
    mdTemp.update(strTemp);
    byte[] md = mdTemp.digest();
    int mdLen = md.length;
    char[] str = new char[mdLen * 2];
    int index = 0;
    for (int i = 0; i < mdLen; ++i) {
      byte byte0 = md[i];
      str[index++] = hexDigits[byte0 >>> 4 & 15];
      str[index++] = hexDigits[byte0 & 15];
    }
    return new String(str);
  }

  public static final String md5(String str, String characterSet, Md5Mode mode) {
    String md5 = md5(str, characterSet);
    return Md5Mode.MD5_CAPITAL.equals(mode) ? md5.toUpperCase() : md5.toLowerCase();
  }

  /**
   * 指定编码模式的md5.
   *
   * @param str 待编码字符串
   * @param mode  编码模式
   * @return 返回编码结果
   */
  public static final String md5(String str, Md5Mode mode) {
    String md5 = md5(str, "UTF-8");
    return Md5Mode.MD5_CAPITAL.equals(mode) ? md5.toUpperCase() : md5.toLowerCase();
  }

  /**
   * 编码模式的枚举.
   */
  public enum Md5Mode {
    MD5_LOWERCASE,
    MD5_CAPITAL;

    private Md5Mode() {
    }
  }
}