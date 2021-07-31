package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.syk.user.openapi.model.UserResultModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 用户信息一览
 */
@ApiModel(description = "用户信息一览")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T23:05:28.614729900+08:00[Asia/Shanghai]")

public class UserSearchResultModel   {
  @JsonProperty("users")
  @Valid
  private List<UserResultModel> users = null;

  @JsonProperty("limit")
  private Long limit;

  @JsonProperty("offset")
  private Long offset;

  public UserSearchResultModel users(List<UserResultModel> users) {
    this.users = users;
    return this;
  }

  public UserSearchResultModel addUsersItem(UserResultModel usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<UserResultModel> getUsers() {
    return users;
  }

  public void setUsers(List<UserResultModel> users) {
    this.users = users;
  }

  public UserSearchResultModel limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * minimum: 1
   * @return limit
  **/
  @ApiModelProperty(value = "")

@Min(1L)
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public UserSearchResultModel offset(Long offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * minimum: 0
   * @return offset
  **/
  @ApiModelProperty(value = "")

@Min(0L)
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserSearchResultModel userSearchResultModel = (UserSearchResultModel) o;
    return Objects.equals(this.users, userSearchResultModel.users) &&
        Objects.equals(this.limit, userSearchResultModel.limit) &&
        Objects.equals(this.offset, userSearchResultModel.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users, limit, offset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserSearchResultModel {\n");
    
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

