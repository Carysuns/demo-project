package com.syk.user.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表的Entity.
 */
@Getter
@Setter
@Entity
public class GeneralUser {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private String userName;

  @Column
  private String address;

  @Column
  private String phone;

  @Column
  private LocalDate birthday;

  @Column
  private String userEmail;

  @Column
  private String note;

  @Column
  private String password;

  @Column
  private String nickname;

  @Column
  private String nation;

  @Column
  private String province;

  @Column
  private String city;

  @Column
  private String height;

  @Column
  private Integer age;

  @Column
  private String collage;

  @Column
  private Integer sex;

  @Column
  private String occupation;

  @Column
  private String hobby;

  /**
   * 用户表的无参构造方法.
   */
  public GeneralUser() {

  }
}
