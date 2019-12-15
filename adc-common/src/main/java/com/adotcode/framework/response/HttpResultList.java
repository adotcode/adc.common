package com.adotcode.framework.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 列表结果返回包装器
 *
 * @author risfeng
 * @date 2019-07-14
 */
@NoArgsConstructor
public class HttpResultList<T> extends HttpResult<HttpResultList.ListResult<T>> {

  private static final long serialVersionUID = -1335806323595834147L;

  /**
   * 列表返回
   *
   * @param <T> entity type
   */
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  static class ListResult<T> {

    /**
     * 列表数据集
     */
    private List<T> list;
  }

  /**
   * 成功返回
   *
   * @param data 列表数据
   */
  private HttpResultList(List<T> data) {
    super(new HttpResultList.ListResult<>(data));
  }

  /**
   * ok result
   *
   * @param data data
   * @param <T> object T
   * @return HttpResult<T>
   */
  public static <T> HttpResultList<T> ok(List<T> data) {
    return new HttpResultList<>(data);
  }
}
