/*
 * Created by houyefeng on 2016-11-02.
 */

package com.shuidi.uc.commons.enums;

/**
 * 通用枚举类型，对应数据库中的{@code status}字段.
 *
 * @author houyefeng
 * @version 0.0.1
 * @since 0.0.1 2016-11-02
 */
public enum Status implements Enum<String> {
  DELETED("deleted", "删除"), ENABLED("enabled", "启用"), DISABLED("disabled", "停用");

  private String value;
  private String desc;

  Status(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public String getValue() {
    return this.value;
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
    Status[] values = Status.values();
    for (Status status : values) {
      if (status.getValue().equals(val)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Status{"
        + "value='" + value + '\''
        + ", desc='" + desc + '\''
        + '}';
  }
}
