package com.syk.user.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 用户的基本信息(登录)
 */
@ApiModel(description = "用户的基本信息(登录)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-17T23:49:43.779832900+08:00[Asia/Shanghai]")

public class UserCreateModel   {
  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("birthday")
  private LocalDate birthday;

  @JsonProperty("user_email")
  private String userEmail;

  @JsonProperty("note")
  private String note;

  @JsonProperty("password")
  private String password;

  @JsonProperty("nickname")
  private String nickname;

  @JsonProperty("nation")
  private String nation;

  @JsonProperty("province")
  private String province;

  @JsonProperty("city")
  private String city;

  @JsonProperty("height")
  private String height;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("collage")
  private String collage;

  @JsonProperty("sex")
  private Integer sex;

  @JsonProperty("occupation")
  private String occupation;

  @JsonProperty("hobby")
  private String hobby;

  public UserCreateModel userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * 用户名字
   * @return userName
  **/
  @ApiModelProperty(required = true, value = "用户名字")
  @NotNull

@Size(max=32) 
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserCreateModel address(String address) {
    this.address = address;
    return this;
  }

  /**
   * 用户地址
   * @return address
  **/
  @ApiModelProperty(value = "用户地址")

@Size(max=128) 
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserCreateModel phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * 用户电话
   * @return phone
  **/
  @ApiModelProperty(value = "用户电话")

@Size(max=11) 
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserCreateModel birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  /**
   * 生日
   * @return birthday
  **/
  @ApiModelProperty(value = "生日")

  @Valid

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public UserCreateModel userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * 用户邮箱
   * @return userEmail
  **/
  @ApiModelProperty(required = true, value = "用户邮箱")
  @NotNull

@Size(max=45) 
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public UserCreateModel note(String note) {
    this.note = note;
    return this;
  }

  /**
   * 签名
   * @return note
  **/
  @ApiModelProperty(value = "签名")

@Size(max=100) 
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public UserCreateModel password(String password) {
    this.password = password;
    return this;
  }

  /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(required = true, value = "密码")
  @NotNull

@Size(max=128) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserCreateModel nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * 昵称
   * @return nickname
  **/
  @ApiModelProperty(value = "昵称")

@Size(max=45) 
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public UserCreateModel nation(String nation) {
    this.nation = nation;
    return this;
  }

  /**
   * 国籍
   * @return nation
  **/
  @ApiModelProperty(required = true, value = "国籍")
  @NotNull

@Size(max=45) 
  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public UserCreateModel province(String province) {
    this.province = province;
    return this;
  }

  /**
   * 省份
   * @return province
  **/
  @ApiModelProperty(required = true, value = "省份")
  @NotNull

@Size(max=45) 
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public UserCreateModel city(String city) {
    this.city = city;
    return this;
  }

  /**
   * 城市
   * @return city
  **/
  @ApiModelProperty(required = true, value = "城市")
  @NotNull

@Size(max=45) 
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UserCreateModel height(String height) {
    this.height = height;
    return this;
  }

  /**
   * 身高
   * @return height
  **/
  @ApiModelProperty(required = true, value = "身高")
  @NotNull

@Size(max=45) 
  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public UserCreateModel age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * 身高
   * @return age
  **/
  @ApiModelProperty(value = "身高")


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public UserCreateModel collage(String collage) {
    this.collage = collage;
    return this;
  }

  /**
   * 毕业院校
   * @return collage
  **/
  @ApiModelProperty(value = "毕业院校")

@Size(max=45) 
  public String getCollage() {
    return collage;
  }

  public void setCollage(String collage) {
    this.collage = collage;
  }

  public UserCreateModel sex(Integer sex) {
    this.sex = sex;
    return this;
  }

  /**
   * 性别
   * @return sex
  **/
  @ApiModelProperty(required = true, value = "性别")
  @NotNull


  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public UserCreateModel occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * 职业
   * @return occupation
  **/
  @ApiModelProperty(required = true, value = "职业")
  @NotNull

@Size(max=45) 
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public UserCreateModel hobby(String hobby) {
    this.hobby = hobby;
    return this;
  }

  /**
   * 爱好
   * @return hobby
  **/
  @ApiModelProperty(value = "爱好")

@Size(max=45) 
  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCreateModel userCreateModel = (UserCreateModel) o;
    return Objects.equals(this.userName, userCreateModel.userName) &&
        Objects.equals(this.address, userCreateModel.address) &&
        Objects.equals(this.phone, userCreateModel.phone) &&
        Objects.equals(this.birthday, userCreateModel.birthday) &&
        Objects.equals(this.userEmail, userCreateModel.userEmail) &&
        Objects.equals(this.note, userCreateModel.note) &&
        Objects.equals(this.password, userCreateModel.password) &&
        Objects.equals(this.nickname, userCreateModel.nickname) &&
        Objects.equals(this.nation, userCreateModel.nation) &&
        Objects.equals(this.province, userCreateModel.province) &&
        Objects.equals(this.city, userCreateModel.city) &&
        Objects.equals(this.height, userCreateModel.height) &&
        Objects.equals(this.age, userCreateModel.age) &&
        Objects.equals(this.collage, userCreateModel.collage) &&
        Objects.equals(this.sex, userCreateModel.sex) &&
        Objects.equals(this.occupation, userCreateModel.occupation) &&
        Objects.equals(this.hobby, userCreateModel.hobby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, address, phone, birthday, userEmail, note, password, nickname, nation, province, city, height, age, collage, sex, occupation, hobby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCreateModel {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    nation: ").append(toIndentedString(nation)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    collage: ").append(toIndentedString(collage)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    hobby: ").append(toIndentedString(hobby)).append("\n");
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

