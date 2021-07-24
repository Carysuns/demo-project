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
   * 根据用户id检索用户表.
   */
  Optional<GeneralUser> findById(Integer id);
}
