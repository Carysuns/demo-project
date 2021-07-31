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
 * 用户的基本信息(更新)
 */
@ApiModel(description = "用户的基本信息(更新)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T23:05:28.614729900+08:00[Asia/Shanghai]")

public class UserUpdateModel   {
  @JsonProperty("id")
  private Integer id;

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

  public UserUpdateModel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * 用户id
   * @return id
  **/
  @ApiModelProperty(value = "用户id")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserUpdateModel userName(String userName) {
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

  public UserUpdateModel address(String address) {
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

  public UserUpdateModel phone(String phone) {
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

  public UserUpdateModel birthday(LocalDate birthday) {
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

  public UserUpdateModel userEmail(String userEmail) {
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

  public UserUpdateModel note(String note) {
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

  public UserUpdateModel password(String password) {
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

  public UserUpdateModel nickname(String nickname) {
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

  public UserUpdateModel nation(String nation) {
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

  public UserUpdateModel province(String province) {
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

  public UserUpdateModel city(String city) {
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

  public UserUpdateModel height(String height) {
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

  public UserUpdateModel age(Integer age) {
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

  public UserUpdateModel collage(String collage) {
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

  public UserUpdateModel sex(Integer sex) {
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

  public UserUpdateModel occupation(String occupation) {
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

  public UserUpdateModel hobby(String hobby) {
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
    UserUpdateModel userUpdateModel = (UserUpdateModel) o;
    return Objects.equals(this.id, userUpdateModel.id) &&
        Objects.equals(this.userName, userUpdateModel.userName) &&
        Objects.equals(this.address, userUpdateModel.address) &&
        Objects.equals(this.phone, userUpdateModel.phone) &&
        Objects.equals(this.birthday, userUpdateModel.birthday) &&
        Objects.equals(this.userEmail, userUpdateModel.userEmail) &&
        Objects.equals(this.note, userUpdateModel.note) &&
        Objects.equals(this.password, userUpdateModel.password) &&
        Objects.equals(this.nickname, userUpdateModel.nickname) &&
        Objects.equals(this.nation, userUpdateModel.nation) &&
        Objects.equals(this.province, userUpdateModel.province) &&
        Objects.equals(this.city, userUpdateModel.city) &&
        Objects.equals(this.height, userUpdateModel.height) &&
        Objects.equals(this.age, userUpdateModel.age) &&
        Objects.equals(this.collage, userUpdateModel.collage) &&
        Objects.equals(this.sex, userUpdateModel.sex) &&
        Objects.equals(this.occupation, userUpdateModel.occupation) &&
        Objects.equals(this.hobby, userUpdateModel.hobby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, address, phone, birthday, userEmail, note, password, nickname, nation, province, city, height, age, collage, sex, occupation, hobby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserUpdateModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

