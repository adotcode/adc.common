package http;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * Http请求返回统一模型
 *
 * @param <T> Object
 * @author risfeng
 * @date 2019/11/21
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> implements Serializable {

  private static final long serialVersionUID = 698122439520888017L;

  /**
   * Http状态码
   */
  private int status;

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
        log.warn("{} But Body Is Null .", "Ok");
        return new HttpResult<>(200, "Body Is Null .", null);
      } else {
        log.info("{}-->Ok", 200);
        return ok(body);
      }
    } catch (Throwable e) {
      log.error("{}-->操作结果异常：", 400, e);
      return fail("操作结果异常:" + e.getMessage());
    }
  }

  /**
   * ok result
   *
   * @return HttpResult
   */
  public static HttpResult<?> ok() {
    //todo:
    return new HttpResult<>(200, "OK", null);
  }

  /**
   * ok result
   *
   * @return HttpResult
   */
  public static <T> HttpResult<T> ok(T body) {
    //todo:
    return new HttpResult<>(200, "OK", body);
  }

  public static HttpResult<?> fail() {
    return new HttpResult<>(3000, "FAIL", null);
  }

  public static <T> HttpResult<T> fail(String message) {
    return new HttpResult<>(3000, message, null);
  }
}
