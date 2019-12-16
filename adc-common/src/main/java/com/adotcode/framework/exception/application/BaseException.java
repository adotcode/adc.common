package com.adotcode.framework.exception.application;

import com.adotcode.framework.enums.IEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常抽象类(未检查异常,代码简洁，一些流行的Java框架（Spring或Hibernate）甚至其他语言根本不使用已检查的异常)
 *
 * @author risfeng
 * @date 2019-07-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseException extends RuntimeException {

  private static final long serialVersionUID = 9053394735482735363L;

  /**
   * exception code
   */
  private String code;

  /**
   * exception message
   */
  private String message;

  /**
   * time stamp millis(js中long型会造成精度损失)
   */
  private final String timestamp = String.valueOf(System.currentTimeMillis());

  /**
   * @param httpResultEnum {@link IEnum}
   */
  BaseException(IEnum<?> httpResultEnum) {
    super(httpResultEnum.getDisplayName());
    this.code = httpResultEnum.getValue().toString();
    this.message = httpResultEnum.getDisplayName();
  }

  /**
   * custom message
   *
   * @param httpResultEnum {@link IEnum} exception code
   * @param message custom message
   */
  BaseException(IEnum<?> httpResultEnum, String message) {
    super(httpResultEnum.getDisplayName());
    this.code = httpResultEnum.getValue().toString();
    this.message = message;
  }

  /**
   * @param httpResultEnum {@link IEnum} exception code
   * @param e exception
   */
  BaseException(IEnum<?> httpResultEnum, Exception e) {
    super(e);
    this.code = httpResultEnum.getValue().toString();
    this.message = httpResultEnum.getDisplayName();
  }
}
