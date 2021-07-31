package com.syk.user.service.user;

import com.syk.user.entity.GeneralUser;

import java.util.Collection;
import java.util.Optional;

/**
 * 用户Service接口.
 */
public interface UserServiceInterface {
    
  /**
   * 用户表检索.
   * @param id 用户id
   * @return 用户表信息
   */
  Optional<GeneralUser> findUserById(Integer id);

  /**
   * 用户存在判断.
   * @param userName 用户名
   * @param password 用户密码
   * @return 用户表信息
   */
  Optional<GeneralUser> findUserByUserNameAndPassword(String userName, String password);

  /**
   * 用户表检索.
   * @return 用户表信息
   */
  Collection<GeneralUser> searchUser(UserSearchCondition condition);

  /**
   * 用户信息登录.
   * @param user 用户表
   */
  void createUser(GeneralUser user);

  /**
   * 用户信息更新.
   * @param user 用户表
   */
  void updateUser(GeneralUser user);

  /**
   * 根据用户id删除用户信息.
   * @param id 用户id
   */
  void deleteById(Integer id);
}
