package com.adotcode.framework.exception.application;

import com.adotcode.framework.enums.result.HttpResultEnum;

/**
 * 通用异常
 *
 * @author risfeng
 * @date 2019/07/25
 */
public class GenericException extends BaseException {

  private static final long serialVersionUID = -3955289008909707402L;

  /**
   * 通用异常处理 {@link HttpResultEnum}
   */
  public GenericException() {
    super(HttpResultEnum.FAILED);
  }

  /**
   * 通用异常处理
   *
   * @param code {@code HttpResultEnum}
   */
  public GenericException(HttpResultEnum code) {
    super(code);
  }

  /**
   * 通用异常处理
   *
   * @param message message
   */
  public GenericException(String message) {
    super(HttpResultEnum.FAILED, message);
  }

  /**
   * 通用异常处理
   *
   * @param code code
   * @param message message
   */
  public GenericException(HttpResultEnum code, String message) {
    super(code, message);
  }
}
