package com.adotcode.framework.response;

import com.adotcode.framework.enums.result.HttpResultEnum;
import com.adotcode.framework.util.i18n.I18nMessageUtils;
import java.io.Serializable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

/**
 * Http请求返回统一模型
 *
 * @param <T> Object
 * @author risfeng
 * @date 2019/11/21
 */
@Data
@Slf4j
public class HttpResult<T> implements Serializable {

  private static final long serialVersionUID = -1318116728395958214L;

  /**
   * Http状态码
   */
  private int status;

  /**
   * Http编码
   */
  private String code;

  /**
   * 提示信息
   */
  private String message;

  /**
   * 时间戳【毫秒】
   */
  private final String timestamp = String.valueOf(System.currentTimeMillis());

  /**
   * 返回消息体
   */
  private T body;

  /**
   * 结果返回
   *
   * @param execute 执行器
   * @param log 日志收集器
   * @param <T> 返回类型
   * @return T
   */
  public static <T> HttpResult<T> result(HttpResultExecute<T> execute, Logger log) {
    try {
      T body = execute.execute();
      if (body == null) {
        if (log.isWarnEnabled()) {
          log.warn("[{}] But Body Is Null .", HttpResultEnum.OK.getName());
        }
        return ok("No Data.");
      } else {
        if (log.isInfoEnabled()) {
          log.info("[{}]-->Ok", HttpResultEnum.OK.getValue());
        }
        return ok(body);
      }
    } catch (Throwable e) {
      if (log.isErrorEnabled()) {
        log.error("[{}]--> result exception .", HttpResultEnum.FAILED.getName(), e);
      }
      return fail(HttpResultEnum.FAILED.getDisplayName());
    }
  }

  public HttpResult() {
  }

  /**
   * ok result
   *
   * @param body data
   */
  HttpResult(T body) {
    status = HttpStatus.OK.value();
    code = HttpResultEnum.OK.getName();
    message = I18nMessageUtils.translate(HttpResultEnum.OK.getDisplayName());
    this.body = body;
  }

  public HttpResult(int status, String code, String message, T body) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.body = body;
  }

  /**
   * ok result
   *
   * @return HttpResult
   */
  public static HttpResult<?> ok() {
    return new HttpResult<>(
        HttpStatus.OK.value(),
        HttpResultEnum.OK.getName(),
        I18nMessageUtils.translate(HttpResultEnum.OK.getDisplayName()),
        null);
  }

  /**
   * ok result
   *
   * @param message custom message
   * @return HttpResult
   */
  public static <T> HttpResult<T> ok(String message) {
    message = StringUtils.defaultString(message, HttpResultEnum.OK.getDisplayName());
    message = I18nMessageUtils.translate(message);
    return new HttpResult<>(
        HttpStatus.OK.value(),
        HttpResultEnum.OK.getName(),
        message,
        null);
  }

  /**
   * ok result
   *
   * @param <T> result type
   * @param body body data
   * @return HttpResult
   */
  public static <T> HttpResult<T> ok(T body) {
    return new HttpResult<>(
        HttpStatus.OK.value(),
        HttpResultEnum.OK.getName(),
        I18nMessageUtils.translate(HttpResultEnum.OK.getDisplayName()),
        body);
  }

  /**
   * fail result
   *
   * @return HttpResult
   */
  public static HttpResult<?> fail() {
    return new HttpResult<>(
        HttpStatus.EXPECTATION_FAILED.value(),
        HttpResultEnum.FAILED.getName(),
        I18nMessageUtils.translate(HttpResultEnum.FAILED.getDisplayName()),
        null);
  }

  /**
   * fail result
   *
   * @param <T> result type
   * @param message custom message
   * @return HttpResult
   */
  public static <T> HttpResult<T> fail(String message) {
    message = StringUtils.defaultString(message, HttpResultEnum.FAILED.getDisplayName());
    message = I18nMessageUtils.translate(message);
    return new HttpResult<>(
        HttpStatus.EXPECTATION_FAILED.value(),
        HttpResultEnum.FAILED.getName(),
        message,
        null);
  }
}
