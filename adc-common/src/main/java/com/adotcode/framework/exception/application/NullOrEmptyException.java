package com.adotcode.framework.exception.application;


import com.adotcode.framework.enums.result.HttpResultEnum;

/**
 * Null或空异常
 *
 * @author risfeng
 * @version 1.0.0
 * @date 2019-07-21
 */
public class NullOrEmptyException extends BaseException {

  private static final long serialVersionUID = 6467571653798792346L;

  /**
   * default message:参数为null或空
   */
  public NullOrEmptyException() {
    super(HttpResultEnum.NULL_OR_EMPTY);
  }

  /**
   * custom message
   *
   * @param message message
   */
  public NullOrEmptyException(String message) {
    super(HttpResultEnum.NULL_OR_EMPTY, message);
  }

}
