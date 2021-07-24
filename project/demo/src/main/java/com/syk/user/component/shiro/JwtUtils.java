package com.syk.user.component.shiro;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Jwt工具类类.
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "com.syk.jwt")
public class JwtUtils {
  
  // 秘钥
  private String secret;

  // 有效时间
  private long expire;
  
  // 头部
  private String header;

  /**
   * 生成jwt token.
   * @return Jwts
   */
  public String generateToken(long userId) {

    Date nowDate = new Date();
    // 过期时间
    Date expirDate = new Date(nowDate.getTime() + expire * 1000);

    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setSubject(userId + "")
        .setIssuedAt(nowDate)
        .setExpiration(expirDate)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  /**
   * 根据token获取Claims.
   * @return Claims
   */
  public Claims getClaimByToken(String token) {

    try {
        
      return Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token)
          .getBody();
    } catch (Exception e) {
        
      log.debug("validate is token error", e);
      return null;
    }
  }

  /**
   * token是否过期.
   * @return true： 过期
   */
  public  Boolean isTokenExpired(Date expiration) {

    return expiration.before(new Date());
  }
}
