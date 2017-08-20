package com.shuidi.uc.commons.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wandy on 17-8-20.
 */
public class UserCheckerUtil {

  /**
   * 教研是否是手机号码.
   *
   * @param unCheck 待校验字符
   * @return 教研结果
   */
  public static boolean isPhone(String unCheck) {
    if (StringUtils.isBlank(unCheck)) {
      return false;
    }
    //1 开头的11位数字
    Pattern pattern = Pattern.compile("^[1][0-9]{10}$");
    Matcher matcher = pattern.matcher(unCheck);
    return matcher.matches();
  }
}
