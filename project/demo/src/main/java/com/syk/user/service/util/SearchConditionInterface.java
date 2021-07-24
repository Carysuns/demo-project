package com.syk.user.service.util;

/**
 * 定义检索共同字段的接口.
 */
public interface SearchConditionInterface {

  public Long getLimit();

  public Long getOffset();
  
  public abstract  org.springframework.data.domain.Sort getOrders();
}
