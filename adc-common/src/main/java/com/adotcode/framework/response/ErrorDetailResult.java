package com.adotcode.framework.response;

import com.adotcode.framework.util.http.RequestUtils;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误详细返回模型
 *
 * @author risfeng
 * @date 2019/12/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailResult implements Serializable {

  private static final long serialVersionUID = -9037467953572051085L;
  /**
   * 资源标识
   */
  private String uri = RequestUtils.getRequestAllUrl();

  /**
   * 错误详情
   */
  private Object message;

  /**
   * 构造
   *
   * @param message 错误信息
   */
  private ErrorDetailResult(Object message) {
    this.message = message;
  }

  /**
   * 获取一个实例
   *
   * @param message 错误信息
   * @return ErrorDetailResult
   */
  public static ErrorDetailResult getInstance(Object message) {
    return new ErrorDetailResult(message);
  }

}
