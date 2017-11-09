package com.shuidi.commons.utils;

import com.shuidi.commons.exception.CheckedException;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.function.Supplier;

public class CheckUtils {

  /**
   * 检查数据是否为null,字符串会检查 empty 值不会被检查.
   *
   * @param data 待检查数据
   */
  public static void notNull(Object data) {
    notNull(data,"check Object can't be null");
  }
  /**
   * 检查数据是否为null,字符串会检查 empty 值不会被检查.
   *
   * @param data 待检查数据
   * @param supplier 信息数据
   */
  public static void notNull(Object data,Supplier<String> supplier) {
    notNull(data,supplier.get());
  }

  /**
   * 检查数据是否为null,字符串会检查 empty 值不会被检查.
   *
   * @param data 待检查数据
   * @param message 描述数据
   */
  public static void notNull(Object data, String message ) {
    //Optional.of(data); optional //检查方式
    Objects.requireNonNull(data,message); //jdk 自带检查方式
  }

  /**
   * 检查数据是否为null,字符串会检查 empty 值,不会被通过,list map collect等均会检查.
   *
   * @param data 待检查数据
   */
  public static void notEmpty(Object data) {
    notNull(data);
    if (data instanceof List && ((List) data).size() <= 0) {
      throw new CheckedException("check List can't be empty");
    }
    if (data instanceof Map && ((Map) data).isEmpty()) {
      throw new CheckedException("check Map can't be empty");
    }
    if (data instanceof Set && ((Set) data).isEmpty()) {
      throw new CheckedException("check Set can't be empty");
    }
    if (data instanceof Queue && ((Queue) data).size() <= 0) {
      throw new CheckedException("check Queue can't be empty");
    }
    if (data instanceof Stack && ((Stack) data).size() <= 0) {
      throw new CheckedException("check Stack can't be empty");
    }
    if (data instanceof Vector && ((Vector) data).size() <= 0) {
      throw new CheckedException("check Vector can't be empty");
    }
    if (data instanceof String && StringUtils.isBlank((String) data)) {
      throw new CheckedException("check string can't be empty");
    }
  }

  /**
   * 检查数据是否为null,字符串会检查 empty 值,不会被通过,list map collect等均会检查.
   *
   * @param data 待检查数据
   */
  public static boolean isEmpty(Object data) {
    if (Objects.isNull(data)) {
      return true;
    } else if (data instanceof List && ((List) data).size() <= 0) {
      return true;
    } else if (data instanceof Map && ((Map) data).isEmpty()) {
      return true;
    } else if (data instanceof Set && ((Set) data).isEmpty()) {
      return true;
    } else if (data instanceof Queue && ((Queue) data).size() <= 0) {
      return true;
    } else if (data instanceof Stack && ((Stack) data).size() <= 0) {
      return true;
    } else if (data instanceof Vector && ((Vector) data).size() <= 0) {
      return true;
    } else if (data instanceof String && StringUtils.isBlank((String) data)) {
      return true;
    }
    return false;
  }

  /**
   * 检查不能小于0
   *
   * @param data 待检查数据
   */
  public static void greaterThenZero(Integer data) {
    notNull(data);
    if (data <= 0) {
      throw new CheckedException("check Integer can't less then 0");
    }
  }

  /**
   * 检查不能小于0
   *
   * @param data 待检查数据
   */
  public static void greaterThenZero(Long data) {
    notNull(data);
    if (data <= 0L) {
      throw new CheckedException("check Long can't less then 0");
    }
  }

  /**
   * 检查不能小于0
   *
   * @param data 待检查数据
   */
  public static void greaterThenZero(Double data) {
    notNull(data);
    if (data <= 0) {
      throw new CheckedException("check Double can't less then 0");
    }
  }


}
