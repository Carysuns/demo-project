package com.syk.user.service.user;

import com.syk.user.service.util.SearchConditionInterface;
import lombok.Builder;
import lombok.Value;

import org.springframework.data.domain.Sort;

/**
 * 用户表检索字段集合类.
 */
@Value
@Builder(toBuilder = true)
public class UserSearchCondition implements SearchConditionInterface {

  Integer id;

  String userName;

  String address;

  String phone;

  String nickname;

  String nation;

  String province;

  String city;

  String occupation;

  Integer age;

  Integer sex;

  String collage;

  Long limit;

  Long offset;

  Sort orders;
}
