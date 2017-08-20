/*
 * Created by houyefeng on 2016-10-19.
 */

package com.shuidi.commons.exception;

import com.shuidi.commons.Result;
import com.shuidi.commons.enums.State;

/**
 * Service需要抛出异常时统一转换为{@code ServiceException}.
 *
 * @author houyefeng
 * @version 0.0.1
 * @since 0.0.1 2016-10-18
 */
public class ServiceException extends RuntimeException {
  private static final long serialVersionUID = -3871417883499936163L;

  private Result<Object, State> result = null;

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(Throwable cause) {
    super(cause);
  }

  public ServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceException(Result<Object, State> result, Throwable cause) {
    super(result.getMessage(), cause);
    this.result = result;
  }

  public ServiceException(Result<Object, State> result) {
    super(result.getMessage());
    this.result = result;
  }

  public Result<Object, State> getResult() {
    return result;
  }
}
