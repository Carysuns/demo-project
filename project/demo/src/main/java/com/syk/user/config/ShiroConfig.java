package com.syk.user.config;

import com.syk.user.component.shiro.AccountRealm;
import com.syk.user.component.shiro.JwtFilter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro配置类.
 */
@Configuration
public class ShiroConfig {
    
  @Autowired
  RedisSessionDAO redisSessionDao;

  @Autowired
  RedisCacheManager redisCacheManager;

  @Autowired
  JwtFilter jwtFilter;

  /**
   * 自动注入SessionManager.
   */
  @Bean
  public SessionManager sessionManager() {

    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

    // 注入redisSessionDao
    sessionManager.setSessionDAO(redisSessionDao);
    return sessionManager;
  }

  /**
   * 自动注入SessionsSecurityManager.
   */
  @Bean
  public SessionsSecurityManager securityManager(
      AccountRealm realms, SessionManager sessionManager) {

    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realms);

    // 注入securityManager
    securityManager.setSessionManager(sessionManager);

    // 注入redisCacheManager
    securityManager.setCacheManager(redisCacheManager);

    return securityManager;
  }

  /**
   * 自动注入ShiroFilterChainDefinition.
   */
  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {

    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

    Map<String, String> filterMap = new LinkedHashMap<>();

    filterMap.put("/**", "jwt");
    chainDefinition.addPathDefinitions(filterMap);
    return chainDefinition;
  }

  /**
   * 自动注入ShiroFilterFactoryBean.
   */
  @Bean("shiroFilterFactoryBean")
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
      ShiroFilterChainDefinition shiroFilterChainDefinition) {

    ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
    shiroFilter.setSecurityManager(securityManager);

    Map<String, Filter> filters = new HashMap<>();
    filters.put("jwt", jwtFilter);
    shiroFilter.setFilters(filters);

    Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();

    shiroFilter.setFilterChainDefinitionMap(filterMap);
    return shiroFilter;
  }
}
