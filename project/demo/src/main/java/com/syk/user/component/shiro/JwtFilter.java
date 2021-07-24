package com.syk.user.component.shiro;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.json.JSONUtil;
import com.syk.user.controller.util.Result;
import io.jsonwebtoken.Claims;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Jwt过滤器配置类.
 */
@Component
public class JwtFilter extends AuthenticatingFilter {

  @Autowired
  JwtUtils jwtUtils;

  @Override
  protected AuthenticationToken createToken(
      ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
    
    HttpServerRequest request = (HttpServerRequest) servletRequest;
    String jwt = request.getHeader("Authoriazation");

    if (jwt == null || "".equals(jwt)) {

      return null;
    }
    return new JwtToken(jwt);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest servletRequest, 
      ServletResponse servletResponse) throws Exception {
    
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    String jwt = request.getHeader("Authoriazation");

    if (jwt == null || "".equals(jwt)) {

      return true;
    } else {

      // 校验jwt
      Claims claims = jwtUtils.getClaimByToken(jwt);
      if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {

        throw new ExpiredCredentialsException("token已失效，请重新登录");
      }

      // 执行登录
      return executeLogin(servletRequest, servletResponse);
    }
  } 
  
  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, 
      ServletRequest servletRequest, ServletResponse servletResponse) {

    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

    Throwable throwable = e.getCause() == null ? e : e.getCause();

    Result result = Result.fail(401, throwable.getMessage());

    String jsonResult = JSONUtil.toJsonStr(result);

    try {
      httpServletResponse.getWriter().print(jsonResult);
    } catch (IOException e1) {
      
      e1.printStackTrace();
    }

    return false;
  }
}
