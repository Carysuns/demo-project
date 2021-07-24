package com.syk.user.controller.user;

import com.syk.user.entity.GeneralUser;
import com.syk.user.openapi.model.UserCreateModel;
import com.syk.user.openapi.model.UserResultModel;
import com.syk.user.openapi.model.UserUpdateModel;

/**
 * 用户Controller的MapperInterface.
 */
public interface UserControllerMapperInterface {

  /**
   * GeneralUser转换成UserResultModel.
   * @param generalUser GeneralUser
   * @return UserResultModel
   */
  UserResultModel toUserResultModel(GeneralUser generalUser);

  /**
   * UserCreateModel转换成GeneralUser.
   * @param createModel 用户信息登录model
   * @return GeneralUser
   */
  GeneralUser toGeneralUser(UserCreateModel createModel);

  /**
   * UserUpdateModel转换成GeneralUser.
   * @param updateModel 用户的基本情报(更新)
   * @return GeneralUser
   */
  GeneralUser toGeneralUser(UserUpdateModel updateModel);
}
