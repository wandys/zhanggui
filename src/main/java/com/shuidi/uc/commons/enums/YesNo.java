/*
 * Created by houyefeng on 2016-10-19.
 */

package com.shuidi.uc.commons.enums;

/**
 * 通用枚举类型，数据库中的值是yes、no时使用.
 *
 * @author houyefeng
 * @since 0.0.1 2016-10-19
 */
public enum YesNo implements Enum<String> {
  YES("yes", "是"), NO("no", "否");

  YesNo(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  private String value;
  private String desc;

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  /**
   * 判断{@code val}是不是合法的枚举值.
   *
   * @param val 枚举值
   * @return 如果{@code val}是一个合法的枚举值返回true，否则返回false
   */
  public static boolean contents(String val) {
    YesNo[] values = YesNo.values();
    for (YesNo zo : values) {
      if (zo.getValue().equals(val)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return new StringBuffer("YesNo{").append("value='").append(value)
        .append("', desc='").append(desc)
        .append("'}").toString();
  }
}
