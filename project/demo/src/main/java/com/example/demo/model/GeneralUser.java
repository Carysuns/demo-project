package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Value;

/**
 * 用户表的Entity。
 */
@Value
@Builder(toBuilder = true)
public class GeneralUser {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String userName;

  String address;

  String phone;
}
