package com.syk.user.component.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JwtToken类.
 */
public class JwtToken implements AuthenticationToken {

  private String token;

  public JwtToken(String jwt) {

    this.token = jwt;
  }

  @Override
  public Object getCredentials() {
    
    return null;
  }

  @Override
  public Object getPrincipal() {
    
    return null;
  }  
}
