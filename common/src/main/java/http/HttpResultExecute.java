package http;

/**
 * Http请求统一返回执行接口
 *
 * @author risfeng
 * @date 2019/11/22
 */
public interface HttpResultExecute<T> {

  /**
   * 返回结果执行
   *
   * @return T
   * @throws Exception 异常
   */
  public T execute() throws Exception;
}
