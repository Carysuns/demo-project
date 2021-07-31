package com.syk.user.repository;

import com.syk.user.entity.GeneralUser;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户Repository接口.
 */
public interface UserRepositoryInterface extends CrudRepository<GeneralUser, Long>, 
    JpaSpecificationExecutor<GeneralUser> {

  /**
   * 用户表检索.
   * @param id 用户id
   * @return 用户表信息
   */
  Optional<GeneralUser> findById(Integer id);

  /**
   * 用户存在判断.
   * @param userName 用户名
   * @param password 用户密码
   * @return 用户表信息
   */
  Optional<GeneralUser> findByUserNameAndPassword(String userName, String password);
}
