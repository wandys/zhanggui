/*
 * Created by houyefeng on 2016-10-18.
 */

package com.shuidi.commons;

import java.io.Serializable;

/**
 * Service返回数据给API以及API返回JSON时使用.
 * <p>
 * D是返回数据的类型；
 * C是状态码类型，控制层可以根据此状态码做适当的流程控制，可以是任何类型的对象，建议使用枚举类型。
 * </p>
 *
 * @author houyefeng
 * @version 0.0.1
 * @see ResultSet
 * @since 0.0.1 2016-10-18
 */
public class Result<D, C> implements Serializable {
  private static final long serialVersionUID = -3210645583052311001L;
  private C code;
  private String message;
  private D data;

  /**
   * API可以根据此状态码做适当的流程控制，可以是任何类型的对象，建议使用枚举类型.
   *
   * @return 状态码
   */
  public C getCode() {
    return code;
  }

  /**
   * API可以根据此状态码做适当的流程控制，可以是任何类型的对象，建议使用枚举类型.
   *
   * @param code 状态码
   */
  public void setCode(C code) {
    this.code = code;
  }

  /**
   * 返回{@code code}描述信息，用于对{@code code}进行补充说明.
   *
   * @return {@code code}的补充说明
   */
  public String getMessage() {
    return message;
  }

  /**
   * {@code code}的补充说明.
   *
   * @param message {@code code}的补充说明
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Service返回给API的数据对象，可以是任何类型.
   *
   * @return 数据对象
   */
  public D getData() {
    return data;
  }

  /**
   * Service返回给API的数据对象，可以是任何类型.
   *
   * @param data 数据对象
   */
  public void setData(D data) {
    this.data = data;
  }
}
