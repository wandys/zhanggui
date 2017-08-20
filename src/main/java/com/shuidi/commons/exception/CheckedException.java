/*
 * Created by houyefeng on 2016-10-19.
 */

package com.shuidi.commons.exception;

import com.shuidi.commons.Result;
import com.shuidi.commons.enums.State;

/**
 * 校验不通过时使用异常{@code CheckedException}.
 *
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2017-08-20
 */
public class CheckedException extends RuntimeException {
  private static final long serialVersionUID = -3871417883499936163L;

  private Result<Object, State> result = null;

  public CheckedException(String message) {
    super(message);
  }

  public CheckedException(Throwable cause) {
    super(cause);
  }

  public CheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public CheckedException(Result<Object, State> result, Throwable cause) {
    super(result.getMessage(), cause);
    this.result = result;
  }

  public CheckedException(Result<Object, State> result) {
    super(result.getMessage());
    this.result = result;
  }

  public Result<Object, State> getResult() {
    return result;
  }
}
