package com.syk.user.component.exception;


/**
 * 数据找不到的异常类.
 */
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * 无参构造方法.
   */
  public ResourceNotFoundException() {


  }
    
  /**
   * 构造方法.
   */
  public ResourceNotFoundException(String msg) {

    super(msg);
  }
}
