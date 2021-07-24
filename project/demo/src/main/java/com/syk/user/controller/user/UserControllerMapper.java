
package com.syk.user.controller.user;

import com.syk.user.entity.GeneralUser;
import com.syk.user.openapi.model.UserCreateModel;
import com.syk.user.openapi.model.UserResultModel;

import com.syk.user.openapi.model.UserUpdateModel;
import org.springframework.stereotype.Component;

/**
 * 用户Controller的Mapper.
 */
@Component
public class UserControllerMapper implements UserControllerMapperInterface {
    
  /**
   * GeneralUser转换成UserResultModel.
   * @param generalUser GeneralUser
   * @return UserResultModel
   */
  @Override
  public UserResultModel toUserResultModel(GeneralUser generalUser) {

    // 用户信息model的设定
    UserResultModel resultModel = new UserResultModel();
    // 用户id
    resultModel.setId(generalUser.getId());
    // 用户名字
    resultModel.setUserName(generalUser.getUserName());
    // 用户地址
    resultModel.setAddress(generalUser.getAddress());
    // 用户电话
    resultModel.setPhone(generalUser.getPhone());
    // 生日
    resultModel.setBirthday(generalUser.getBirthday());
    // 用户邮箱
    resultModel.setUserEmail(generalUser.getUserEmail());
    // 简介
    resultModel.setNote(generalUser.getNote());
    // 密码
    resultModel.setPassword(generalUser.getPassword());
    // 昵称
    resultModel.setNickname(generalUser.getNickname());
    // 国籍
    resultModel.setNation(generalUser.getNation());
    // 省份
    resultModel.setProvince(generalUser.getProvince());
    // 城市
    resultModel.setCity(generalUser.getCity());
    // 身高
    resultModel.setHeight(generalUser.getHeight());
    // 年龄
    resultModel.setAge(generalUser.getAge());
    // 毕业院校
    resultModel.setCollage(generalUser.getCollage());
    // 性别
    resultModel.setSex(generalUser.getSex());
    // 职业
    resultModel.setOccupation(generalUser.getOccupation());
    // 爱好
    resultModel.setHobby(generalUser.getHobby());

    return resultModel;
  }

  /**
   * UserCreateModel转换成GeneralUser.
   * @param createModel 用户信息登录model
   * @return GeneralUser
   */
  @Override
  public GeneralUser toGeneralUser(UserCreateModel createModel) {

    // 用户表的Entity的创建
    GeneralUser user = new GeneralUser();
    // 用户名字
    user.setUserName(createModel.getUserName());
    // 用户地址
    user.setAddress(createModel.getAddress());
    // 用户电话
    user.setPhone(createModel.getPhone());
    // 生日
    user.setBirthday(createModel.getBirthday());
    // 用户邮箱
    user.setUserEmail(createModel.getUserEmail());
    // 简介
    user.setNote(createModel.getNote());
    // 密码
    user.setPassword(createModel.getPassword());
    // 昵称
    user.setNickname(createModel.getNickname());
    // 国籍
    user.setNation(createModel.getNation());
    // 省份
    user.setProvince(createModel.getProvince());
    // 城市
    user.setCity(createModel.getCity());
    // 身高
    user.setHeight(createModel.getHeight());
    // 年龄
    user.setAge(createModel.getAge());
    // 毕业院校
    user.setCollage(createModel.getCollage());
    // 性别
    user.setSex(createModel.getSex());
    // 职业
    user.setOccupation(createModel.getOccupation());
    // 爱好
    user.setHobby(createModel.getHobby());

    return user;
  }

  /**
   * UserUpdateModel转换成GeneralUser.
   * @param updateModel 用户的基本情报(更新)
   * @return GeneralUser
   */
  @Override
  public GeneralUser toGeneralUser(UserUpdateModel updateModel) {

    // 用户表的Entity的创建
    GeneralUser user = new GeneralUser();
    // 用户id
    user.setId(updateModel.getId());
    // 用户名字
    user.setUserName(updateModel.getUserName());
    // 用户地址
    user.setAddress(updateModel.getAddress());
    // 用户电话
    user.setPhone(updateModel.getPhone());
    // 生日
    user.setBirthday(updateModel.getBirthday());
    // 用户邮箱
    user.setUserEmail(updateModel.getUserEmail());
    // 简介
    user.setNote(updateModel.getNote());
    // 密码
    user.setPassword(updateModel.getPassword());
    // 昵称
    user.setNickname(updateModel.getNickname());
    // 国籍
    user.setNation(updateModel.getNation());
    // 省份
    user.setProvince(updateModel.getProvince());
    // 城市
    user.setCity(updateModel.getCity());
    // 身高
    user.setHeight(updateModel.getHeight());
    // 年龄
    user.setAge(updateModel.getAge());
    // 毕业院校
    user.setCollage(updateModel.getCollage());
    // 性别
    user.setSex(updateModel.getSex());
    // 职业
    user.setOccupation(updateModel.getOccupation());
    // 爱好
    user.setHobby(updateModel.getHobby());

    return user;
  }
}
