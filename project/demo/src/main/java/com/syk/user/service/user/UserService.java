package com.syk.user.service.user;

import cn.hutool.crypto.SecureUtil;

import com.syk.user.component.exception.Message;
import com.syk.user.component.exception.ResourceNotFoundException;
import com.syk.user.entity.GeneralUser;
import com.syk.user.repository.UserRepositoryInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 用户相关操作 Service.
 */
@Service
public class UserService implements UserServiceInterface {

  @Autowired
  private UserRepositoryInterface userRepository;

  /**
   * 用户表检索.
   * @param id 用户id
   * @return 用户表信息
   */
  @Override
  public Optional<GeneralUser> fingUserById(Integer id) {

    return this.userRepository.findById(id);
  }

  /**
   * 用户表检索.
   * @param condition UserSearchCondition
   * @return 用户表信息
   */
  @Override
  public Collection<GeneralUser> searchUser(UserSearchCondition condition) {

    // 可变条件的拼接
    Specification<GeneralUser> query = new Specification<GeneralUser>() {
      
      @Override
      public Predicate toPredicate(Root<GeneralUser> root, 
          CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // id
        if (condition.getId() != null) {

          predicates.add(criteriaBuilder.equal(root.get("id"), condition.getId()));
        }

        // user_name
        if (condition.getUserName() != null) {

          predicates.add(criteriaBuilder.equal(root.get("userName"), condition.getUserName()));
        }

        // address
        if (condition.getAddress() != null) {

          predicates.add(criteriaBuilder.equal(root.get("address"), condition.getAddress()));
        }

        // phone
        if (condition.getPhone() != null) {

          predicates.add(criteriaBuilder.equal(root.get("phone"), condition.getPhone()));
        }

        // nickname
        if (condition.getNickname() != null) {

          predicates.add(criteriaBuilder.equal(root.get("nickname"), condition.getNickname()));
        }

        // nation
        if (condition.getNation() != null) {

          predicates.add(criteriaBuilder.equal(root.get("nation"), condition.getNation()));
        }

        // province
        if (condition.getProvince() != null) {

          predicates.add(criteriaBuilder.equal(root.get("province"), condition.getProvince()));
        }

        // city
        if (condition.getCity() != null) {

          predicates.add(criteriaBuilder.equal(root.get("city"), condition.getCity()));
        }

        // age
        if (condition.getAge() != null) {

          predicates.add(criteriaBuilder.equal(root.get("age"), condition.getAge()));
        }

        // sex
        if (condition.getSex() != null) {

          predicates.add(criteriaBuilder.equal(root.get("sex"), condition.getSex()));
        }

        // collage
        if (condition.getCollage() != null) {

          predicates.add(criteriaBuilder.equal(root.get("collage"), condition.getCollage()));
        }

        // occupation
        if (condition.getOccupation() != null) {

          predicates.add(criteriaBuilder.equal(root.get("occupation"), condition.getOccupation()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
      }
    };

    // 返回动态查询的结果
    return userRepository.findAll(query, condition.getOrders());
  }

  /**
   * 用户信息登录.
   * @param user 用户表
   */
  @Override
  @Transactional
  public void createUser(GeneralUser user) {

    // 对密码进行加密
    String encryptedPassword = SecureUtil.md5(user.getPassword());
    user.setPassword(encryptedPassword);

    this.userRepository.save(user);
  }

  /**
   * 用户信息更新.
   * @param user 用户表
   */
  @Override
  @Transactional
  public void updateUser(GeneralUser user) {

    // 根据id去检索用户信息
    Optional<GeneralUser> userInfo = this.userRepository.findById(user.getId());

    // 如果用户数据不存在
    if (!userInfo.isPresent()) {

      throw new ResourceNotFoundException(Message.RESOURCE_NOT_FOUND);
    } else {

      this.userRepository.save(user);
    }
  }

  /**
   * 根据用户id删除用户信息.
   * @param id 用户id
   */
  @Override
  @Transactional
  public void deleteById(Integer id) {

    // 根据id去检索用户信息
    Optional<GeneralUser> user = this.userRepository.findById(id);

    // 如果用户数据不存在
    if (!user.isPresent()) {

      throw new ResourceNotFoundException(Message.RESOURCE_NOT_FOUND);
    } else {

      this.userRepository.delete(user.get());
    }
  }
}
