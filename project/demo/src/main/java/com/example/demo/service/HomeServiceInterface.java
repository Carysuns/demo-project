package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.GeneralUser;

/**
 * 欢迎界面Service接口。
 */
public interface HomeServiceInterface {
    
  /**
   * 用户表检索。
   * @param id 用户id
   * @return 用户表信息
   */
  Optional<GeneralUser> getGenegerUser(Integer id);
}
