/*
 * Created by houyefeng on 2016-10-19.
 */

package com.shuidi.commons.enums;

/**
 * 处理状态，在Service需要向API返回处理状态时使用.
 *
 * @author houyefeng
 * @version 0.0.1
 * @since 0.0.1 2016-10-18
 */
public enum State {
  SUCCESS("success"), FAILED("failed");
  private String code;

  private State(String code) {
    this.code = code;
  }
}
