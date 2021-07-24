package com.syk.user.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置跨域访问的类.
 */
@WebFilter("/*")
public class CorsFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) 
      throws IOException, ServletException {

    //解决跨域访问报错
    HttpServletResponse response = (HttpServletResponse) resp;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    // 设置过期时间
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
    // 支持HTTP 1.1.
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
    chain.doFilter(request, resp);
  }

  /**
   * 初期化.
   */
  @Override
  public void init(FilterConfig filterConfig) {

  }

  /**
   * 销毁.
   */
  @Override
  public void destroy() {

  }
}
