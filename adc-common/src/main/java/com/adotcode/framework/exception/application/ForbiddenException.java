package com.adotcode.framework.exception.application;

import com.adotcode.framework.enums.result.HttpResultEnum;

/**
 * 禁止访问异常处理
 *
 * @author risfeng
 * @date 2019-07-22
 */
public class ForbiddenException extends BaseException {

  private static final long serialVersionUID = -7472953075828927558L;

  /**
   * default message:无权访问
   */
  public ForbiddenException() {
    super(HttpResultEnum.FORBIDDEN);
  }

  /**
   * custom message
   */
  public ForbiddenException(String message) {
    super(HttpResultEnum.FORBIDDEN, message);
  }
}
