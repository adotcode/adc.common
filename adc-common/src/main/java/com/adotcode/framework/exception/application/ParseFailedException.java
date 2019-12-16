package com.adotcode.framework.exception.application;

import com.adotcode.framework.enums.result.HttpResultEnum;
import java.text.ParseException;

/**
 * 转换失败异常
 *
 * @author risfeng
 * @date 2019/08/17
 */
public class ParseFailedException extends BaseException {

  private static final long serialVersionUID = -6599940145228665597L;

  /**
   * 转换失败异常处理 {@code HttpResultEnum.PARSE_FAILED}
   */
  public ParseFailedException(ParseException e) {
    super(HttpResultEnum.PARSE_FAILED, e);
  }

  /**
   * 转换失败异常处理 {@code HttpResultEnum.PARSE_FAILED}
   */
  public ParseFailedException() {
    super(HttpResultEnum.PARSE_FAILED);
  }

  /**
   * 转换失败异常处理
   *
   * @param code {@code HttpResultEnum}
   */
  public ParseFailedException(HttpResultEnum code) {
    super(code);
  }

  /**
   * 转换失败异常处理
   *
   * @param message message
   */
  public ParseFailedException(String message) {
    super(HttpResultEnum.PARSE_FAILED, message);
  }

  /**
   * 转换失败异常处理
   *
   * @param code code
   * @param message message
   */
  public ParseFailedException(HttpResultEnum code, String message) {
    super(code, message);
  }
}
