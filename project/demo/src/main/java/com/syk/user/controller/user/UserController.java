package com.syk.user.controller.user;

import com.syk.user.entity.GeneralUser;
import com.syk.user.openapi.api.UserApi;
import com.syk.user.openapi.model.UserCreateModel;
import com.syk.user.openapi.model.UserResultModel;
import com.syk.user.openapi.model.UserSearchResultModel;
import com.syk.user.openapi.model.UserUpdateModel;
import com.syk.user.service.user.UserSearchCondition;
import com.syk.user.service.user.UserServiceInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import jp.co.tpj.backendcomponent.app.ControllerUtility;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Controller.
 */
@RestController
@Slf4j
public class UserController implements UserApi {

  @Autowired
  private UserServiceInterface userService;

  @Autowired
  private UserControllerMapperInterface userControllerMapper;
    
  /**
   * 用户表检索.
   * @return 用户表信息
   */
  @Override
  public ResponseEntity<UserResultModel> findById(Integer id) {

    log.debug("UserController.findById() : id {}", id);

    // 调用userService，根据id取得用户信息
    Optional<GeneralUser> user = this.userService.fingUserById(id);

    // 用户信息存在
    if (user.isPresent()) {

      // GeneralUser转换成UserResultModel
      GeneralUser generalUser = user.get();
      UserResultModel resultModel = userControllerMapper.toUserResultModel(generalUser);
      return ResponseEntity.status(HttpStatus.OK).body(resultModel);
    } else {

      // 返回404
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  /**
   * 用户表检索.
   * @param id 用户id
   * @param userName 用户名字
   * @param address 地址
   * @param phone 手机号
   * @param limit 单次检索限定条数
   * @param offset 偏移量
   * @param order 排序字段集合
   * @return 用户表信息一览
   */
  @Override
  public ResponseEntity<UserSearchResultModel> search(
      Integer id,
      String userName,
      String address,
      String nation,
      String province,
      String city,
      Integer age,
      Integer sex,
      String collage,
      String occupation,
      String nickname,
      String phone,
      Long limit,
      Long offset,
      String order) {

    log.debug("UserController.search() : id {}, user_name {}, address {}, nation {}, province {}, "
        + "city {}, age {}, sex {}, collage {}, occupation {}, nickname {}, phone {}, limit {},"
        + "offset {}, order {}",
        id, userName, address, nation, province, city, age, sex, collage, occupation, nickname, 
        phone, limit, offset, order);

    // order的类型转换(String -> Collection<Order>)
    Collection<Order> orders = ControllerUtility.toOrders(GeneralUser.class, order);

    List<Order> orderList = new ArrayList<>();

    // order不为空的情况
    if (order != null) {

      orders.forEach(x -> {

        Order od = x;
        orderList.add(od);
      });
    }

    // Order转换成Sort
    Sort sort = Sort.by(orderList);

    // 用户表检索条件集合的设定
    UserSearchCondition condition = UserSearchCondition.builder()
        .id(id)
        .userName(userName)
        .address(address)
        .phone(phone)
        .age(age)
        .sex(sex)
        .collage(collage)
        .nation(nation)
        .province(province)
        .city(city)
        .occupation(occupation)
        .nickname(nickname)
        .limit(limit)
        .offset(offset)
        .orders(sort)
        .build();
  
    // 调用Service的用户检索方法
    Collection<GeneralUser> generalUsers = this.userService.searchUser(condition);

    // 创建UserSearchResultModel
    UserSearchResultModel result = new UserSearchResultModel();
    result.setLimit(condition.getLimit());
    result.setOffset(condition.getOffset());

    // 检索结果不为空
    if (!generalUsers.isEmpty()) {

      // 用户的基本信息一览的创建
      List<UserResultModel> users = new ArrayList<>();
      generalUsers.forEach(x -> {

        UserResultModel resultModel = this.userControllerMapper.toUserResultModel(x);
        users.add(resultModel);
      });
      result.setUsers(users);
    } else {

      // 返回空数组
      result.setUsers(new ArrayList<>());
    }

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  /**
   * 用户信息登录.
   * @param createModel 用户信息登录model
   */
  @Override
  public ResponseEntity<Void> create(UserCreateModel createModel) {

    log.debug("UserController.create()");
    
    // UserCreateModel转换成GeneralUser
    GeneralUser user = this.userControllerMapper.toGeneralUser(createModel);

    // 调用Service，登录用户信息
    this.userService.createUser(user);

    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  /**
   * 用户信息更新.
   * @param id 用户id
   * @param updateModel 用户的基本情报(更新)
   */
  @Override
  public ResponseEntity<UserResultModel> updateById(Integer id, UserUpdateModel updateModel) {

    log.debug("UserController.updateById() : id {}", id);

    // UserUpdateModel转换成GeneralUser
    GeneralUser user = this.userControllerMapper.toGeneralUser(updateModel);

    // 用户信息更新
    this.userService.updateUser(user);

    // 更新后，用户信息再检索
    Optional<GeneralUser> generalUser = this.userService.fingUserById(id);

    // 如果用户信息存在
    if (generalUser.isPresent()) {

      UserResultModel resultModel = userControllerMapper.toUserResultModel(generalUser.get());
      return ResponseEntity.status(HttpStatus.OK).body(resultModel);
    } else {

      // 返回404
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  /**
   * 根据用户id删除用户信息.
   * @param id 用户id
   */
  @Override
  public ResponseEntity<Void> deleteById(Integer id) {

    log.debug("UserController.deleteById() : id {}", id);

    // 删除用户信息
    this.userService.deleteById(id);

    return ResponseEntity.status(HttpStatus.OK).body(null);
  }
}
