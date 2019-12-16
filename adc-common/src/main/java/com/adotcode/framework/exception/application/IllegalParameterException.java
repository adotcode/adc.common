package com.adotcode.framework.exception.application;

import com.adotcode.framework.enums.result.HttpResultEnum;

/**
 * 非法参数异常
 *
 * @author risfeng
 * @date 2019-07-21
 */
public class IllegalParameterException extends BaseException {

  private static final long serialVersionUID = 6467571653798792346L;

  /**
   * default message:非法的属性
   */
  public IllegalParameterException() {
    super(HttpResultEnum.ILLEGAL_PARAMETER);
  }

  /**
   * custom parameterName
   *
   * @param parameterName 参数名
   */
  public IllegalParameterException(String parameterName) {
    super(HttpResultEnum.ILLEGAL_PARAMETER, String.format("参数[%s]非法.", parameterName));
  }

}
