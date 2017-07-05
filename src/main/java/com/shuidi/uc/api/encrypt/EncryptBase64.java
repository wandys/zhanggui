/*
 * Created by wandy on 2017-02-22.
 */

package com.shuidi.uc.api.encrypt;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2017-02-22
 */
public class EncryptBase64 {

  private static final String CHARACTER_SET = "UTF-8";

  /**
   * 使用Apache方式进行base64编码.
   *
   * @param str 待编码字符串
   * @return 编码结果
   */
  public static final String encodeBase64(String str) {
    return encodeBase64(str,CHARACTER_SET, BaseMode.APACHE);
  }

  /**
   * 使用Apache方式进行base64编码.
   *
   * @param str 待编码字符串
   * @param characterSet 编码方式
   * @param mode 编码模式，普通模式编码结果含有==号
   * @return 编码结果
   */
  public static final String encodeBase64(String str,String characterSet,BaseMode mode) {
    byte[] bytes = null;
    String encode = null;

    if (mode == BaseMode.APACHE) {
      try {
        bytes = str.getBytes(characterSet);
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
      if (bytes != null) {
        encode = Base64.encodeBase64URLSafeString(bytes);
      }
      return encode;
    } else {
      try {
        bytes = str.getBytes(CHARACTER_SET);
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      if (bytes != null) {
        encode = new BASE64Encoder().encode(bytes);
      }
      return encode;
    }

  }

  /**
   * 解码base64.
   *
   * @param base64Str 待解码字符串
   * @return 解码结果
   */
  public static String decodBase64(String base64Str) {
    return decodBase64(base64Str,CHARACTER_SET, BaseMode.APACHE);
  }
  /**
   * 解码base64.
   *
   * @param base64Str 待解码字符串
   * @param characterSet 解码编码方式
   * @return 解码结果
   */
  public static String decodBase64(String base64Str,String characterSet,BaseMode mode) {
    byte[] bytes = null;
    String result = null;
    if (mode == BaseMode.APACHE) {
      if (base64Str != null) {
        try {
          bytes = Base64.decodeBase64(base64Str);
          result = new String(bytes, characterSet);
        } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
        }
      }
      return result;
    } else {
      if (base64Str != null) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
          bytes = decoder.decodeBuffer(result);
          result = new String(bytes, "utf-8");
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      return  result;
    }
  }

  /**
   * 编码模式的枚举.apache模式编码结果不带有==号.
   */
  public enum BaseMode {
    APACHE,
    NORMAL;
    private BaseMode() {
    }
  }
}