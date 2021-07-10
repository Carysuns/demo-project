package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.GeneralUser;
import com.example.demo.service.HomeServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎界面Controller。
 */
@RestController
public class HomeController {

  @Autowired
  private HomeServiceInterface homeService;

  @Autowired
  private JdbcTemplate jdbcTemplate;
    
  /**
   * 用户表检索。
   * @return 用户表信息
   */
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public Optional<GeneralUser> helloString() {

    Optional<GeneralUser> user = this.homeService.getGenegerUser(1);

    return user;
  }

  /**
   * 用户表检索。
   * @return 用户表信息
   */
  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  public List<Map<String, Object>> getUser() {

    String sql = "select * from general_user";
    return jdbcTemplate.queryForList(sql);
  }
}
