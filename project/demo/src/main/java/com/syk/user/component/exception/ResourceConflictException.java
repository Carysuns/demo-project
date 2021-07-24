package com.syk.user.component.exception;

/**
 * 数据冲突的异常类.
 */
public class ResourceConflictException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * 无参构造方法.
   */
  public ResourceConflictException() {


  }

  /**
   * 构造方法.
   */
  public ResourceConflictException(String msg) {

    super(msg);
  }
}
