package com.adotcode.framework.http;

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
        log.warn("[{}] But Body Is Null .", HttpStatus.OK.name());
        return ok("No Data.");
      } else {
        log.info("[{}]-->Ok", HttpStatus.OK.value());
        return ok(body);
      }
    } catch (Throwable e) {
      log.error("[{}]-->操作结果异常：", HttpStatus.EXPECTATION_FAILED.name(), e);
      return fail("操作结果异常:" + e.getMessage());
    }
  }

  public HttpResult() {
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
    return new HttpResult<>(HttpStatus.OK.value(), HttpStatus.OK.name(),
        HttpStatus.OK.getReasonPhrase(), null);
  }

  /**
   * ok result
   *
   * @param msg custom message
   * @return HttpResult
   */
  public static <T> HttpResult<T> ok(String msg) {
    msg = StringUtils.defaultString(msg, HttpStatus.OK.getReasonPhrase());
    return new HttpResult<>(HttpStatus.OK.value(), HttpStatus.OK.name(),
        msg, null);
  }

  /**
   * ok result
   *
   * @param <T> result type
   * @param body body data
   * @return HttpResult
   */
  public static <T> HttpResult<T> ok(T body) {
    return new HttpResult<>(HttpStatus.OK.value(), HttpStatus.OK.name(),
        HttpStatus.OK.getReasonPhrase(), body);
  }

  /**
   * fail result
   *
   * @return HttpResult
   */
  public static HttpResult<?> fail() {
    return new HttpResult<>(HttpStatus.EXPECTATION_FAILED.value(),
        HttpStatus.EXPECTATION_FAILED.name(), HttpStatus.EXPECTATION_FAILED.getReasonPhrase(),
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
    return new HttpResult<>(HttpStatus.EXPECTATION_FAILED.value(),
        HttpStatus.EXPECTATION_FAILED.name(), message, null);
  }
}
