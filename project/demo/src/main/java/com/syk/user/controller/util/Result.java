package com.syk.user.controller.util;

import java.io.Serializable;

import lombok.Data;

/**
 * 统一结果封装类.
 */
@Data
public class Result implements Serializable {

  // response返回的code
  private int code; // 200 201正常，其余为异常

  // response返回的message
  private String message;

  // response返回的数据体
  private Object data;

  /**
   * controller及统一处理返回结构方法定义（成功）.
   * @param data 返回数据体
   * @return 封装后的结果
   */
  public static Result succ(Object data) {

    return succ(200, "操作成功", data);
  }

  /**
   * controller及统一处理返回结构方法定义（成功）.
   * @param code 返回成功的code
   * @param msg 返回成功的message
   * @param data 返回数据体
   * @return 封装后的结果
   */
  public static Result succ(Integer code, String msg, Object data) {

    Result result = new Result();
    result.setCode(code);
    result.setMessage(msg);
    result.setData(data);

    return result;
  }

  /**
   * controller及统一处理返回结构方法定义（失败）.
   * @param code 返回成功的code
   * @param msg 返回成功的message
   * @return 封装后的结果
   */
  public static Result fail(Integer code, String msg) {

    Result result = new Result();
    result.setCode(code);
    result.setMessage(msg);

    return result;
  }
}
