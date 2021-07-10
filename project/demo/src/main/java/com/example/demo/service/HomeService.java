package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.GeneralUser;
// import com.example.demo.repository.UserRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 欢迎界面Service
 */
@Service
public class HomeService implements HomeServiceInterface {

  // @Autowired
  // private UserRepositoryInterface userRepository;
    
  /**
   * 用户表检索。
   * @param id 用户id
   * @return 用户表信息
   */
  @Override
  public Optional<GeneralUser> getGenegerUser(Integer id) {

    GeneralUser generalUser = GeneralUser.builder()
        .id(1)
        .userName("孙永科")
        .address("鞍山")
        .phone("123456")
        .build();
    return Optional.of(generalUser);
  }
}
