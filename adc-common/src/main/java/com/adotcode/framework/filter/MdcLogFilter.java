package com.adotcode.framework.filter;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 日志mdc过滤器
 *
 * @author risfeng
 * @date 2019/09/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MdcLogFilter extends OncePerRequestFilter {

  /**
   * 请求响应头链路跟踪Key名称
   */
  private String responseHeaderKey;
  /**
   * 上游请求头所携带的链路跟踪Key名称
   */
  private String requestHeaderKey;
  /**
   * 记录日志的跟踪Key名称
   */
  private String mdcTrackKey;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain chain) throws IOException, ServletException {
    try {
      String trackId;
      if (StringUtils.isNotBlank(requestHeaderKey) &&
          StringUtils.isNotBlank(request.getHeader(requestHeaderKey))) {
        trackId = request.getHeader(requestHeaderKey);
      } else {
        trackId = UUID.randomUUID().toString().replace("-", "");
      }
      MDC.put(mdcTrackKey, trackId);
      if (StringUtils.isNotBlank(responseHeaderKey)) {
        response.addHeader(responseHeaderKey, trackId);
      }
      chain.doFilter(request, response);
    } finally {
      MDC.remove(mdcTrackKey);
    }
  }
}
