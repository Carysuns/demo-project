package com.syk.user.component.shiro;

import java.io.Serializable;

import lombok.Data;

/**
 * 基本用户信息类.
 */
@Data
public class AccountProfile implements Serializable {
    
  private Integer id;

  private String userName;

  private String address;

  private String phone;
}
