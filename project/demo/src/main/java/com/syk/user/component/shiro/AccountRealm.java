package com.syk.user.component.shiro;

import com.syk.user.entity.GeneralUser;
import com.syk.user.service.user.UserServiceInterface;

import java.util.Optional;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户验证类（通过获取token验证）.
 */
@Component
public class AccountRealm extends AuthenticatingRealm {

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserServiceInterface userService;

  @Override
  public boolean supports(AuthenticationToken token) {

    return token instanceof JwtToken;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
      throws AuthenticationException {
    
    JwtToken jwtToken = (JwtToken) token;

    // 从jwttoken中获取sub，即用户id
    String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
    Optional<GeneralUser> user = userService.fingUserById(Integer.valueOf(userId));

    // 用户不存在
    if (!user.isPresent()) {

      throw new UnknownAccountException("账户不存在");
    }

    AccountProfile profile = new AccountProfile();
    BeanUtils.copyProperties(user.get(), profile);
    return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
  }
}
