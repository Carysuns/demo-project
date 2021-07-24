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
 * 用户的基本信息
 */
@ApiModel(description = "用户的基本信息")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-17T23:49:43.779832900+08:00[Asia/Shanghai]")

public class UserResultModel   {
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

  public UserResultModel id(Integer id) {
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

  public UserResultModel userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * 用户名字
   * @return userName
  **/
  @ApiModelProperty(value = "用户名字")

@Size(max=32) 
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserResultModel address(String address) {
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

  public UserResultModel phone(String phone) {
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

  public UserResultModel birthday(LocalDate birthday) {
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

  public UserResultModel userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * 用户邮箱
   * @return userEmail
  **/
  @ApiModelProperty(value = "用户邮箱")

@Size(max=45) 
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public UserResultModel note(String note) {
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

  public UserResultModel password(String password) {
    this.password = password;
    return this;
  }

  /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(value = "密码")

@Size(max=128) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserResultModel nickname(String nickname) {
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

  public UserResultModel nation(String nation) {
    this.nation = nation;
    return this;
  }

  /**
   * 国籍
   * @return nation
  **/
  @ApiModelProperty(value = "国籍")

@Size(max=45) 
  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public UserResultModel province(String province) {
    this.province = province;
    return this;
  }

  /**
   * 省份
   * @return province
  **/
  @ApiModelProperty(value = "省份")

@Size(max=45) 
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public UserResultModel city(String city) {
    this.city = city;
    return this;
  }

  /**
   * 城市
   * @return city
  **/
  @ApiModelProperty(value = "城市")

@Size(max=45) 
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UserResultModel height(String height) {
    this.height = height;
    return this;
  }

  /**
   * 身高
   * @return height
  **/
  @ApiModelProperty(value = "身高")

@Size(max=45) 
  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public UserResultModel age(Integer age) {
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

  public UserResultModel collage(String collage) {
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

  public UserResultModel sex(Integer sex) {
    this.sex = sex;
    return this;
  }

  /**
   * 性别
   * @return sex
  **/
  @ApiModelProperty(value = "性别")


  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public UserResultModel occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * 职业
   * @return occupation
  **/
  @ApiModelProperty(value = "职业")

@Size(max=45) 
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public UserResultModel hobby(String hobby) {
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
    UserResultModel userResultModel = (UserResultModel) o;
    return Objects.equals(this.id, userResultModel.id) &&
        Objects.equals(this.userName, userResultModel.userName) &&
        Objects.equals(this.address, userResultModel.address) &&
        Objects.equals(this.phone, userResultModel.phone) &&
        Objects.equals(this.birthday, userResultModel.birthday) &&
        Objects.equals(this.userEmail, userResultModel.userEmail) &&
        Objects.equals(this.note, userResultModel.note) &&
        Objects.equals(this.password, userResultModel.password) &&
        Objects.equals(this.nickname, userResultModel.nickname) &&
        Objects.equals(this.nation, userResultModel.nation) &&
        Objects.equals(this.province, userResultModel.province) &&
        Objects.equals(this.city, userResultModel.city) &&
        Objects.equals(this.height, userResultModel.height) &&
        Objects.equals(this.age, userResultModel.age) &&
        Objects.equals(this.collage, userResultModel.collage) &&
        Objects.equals(this.sex, userResultModel.sex) &&
        Objects.equals(this.occupation, userResultModel.occupation) &&
        Objects.equals(this.hobby, userResultModel.hobby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, address, phone, birthday, userEmail, note, password, nickname, nation, province, city, height, age, collage, sex, occupation, hobby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResultModel {\n");
    
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

