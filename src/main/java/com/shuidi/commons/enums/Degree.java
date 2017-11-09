/*
 * Created by houyefeng on 2016-10-19.
 */

package com.shuidi.commons.enums;

import com.shuidi.uc.commons.enums.Enum;
import org.apache.commons.lang.StringUtils;

/**
 * 通用枚举类型，数据库中的值是yes、no时使用.
 *
 * @author houyefeng
 * @since 0.0.1 2016-10-19
 */
public enum Degree implements Enum<String> {
  FIRST("first", "第一级"),
  SECOND("second", "第二级"),
  THIRD("third", "第三级"),
  FOURTH("fourth", "第四级"),
  FIFTH("fifth", "第五级");

  Degree(String value, String desc) {
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

  public Degree getByValue(String value) {
    if (StringUtils.isBlank(value)) {
      return null;
    }
    for (Degree degree : Degree.values()) {
      if (degree.getValue().equals(value)) {
        return degree;
      }
    }
    return null;
  }

  /**
   * 判断{@code val}是不是合法的枚举值.
   *
   * @param val 枚举值
   * @return 如果{@code val}是一个合法的枚举值返回true，否则返回false
   */
  public static boolean contents(String val) {
    Degree[] values = Degree.values();
    for (Degree zo : values) {
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
