/**
 * ServiceRetryAspect.java
 * 
 * All Rights Reserved,
 * Copyright 2021 By syk.
 */

package com.syk.user.component.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

/**
 * 在Service的每个处理中插入重试的纵横的类.
 */
@Aspect
@Component
public class ServiceRetryAspect {
  /**
   * All Rights Reserved, <br />
   * Copyright 2021 By syk.
   */
  public static final String COPYRIGHT = "Copyright 2021 By syk.";

  /**
   * Sunyk Project CONFIDENTIAL.
   */
  public static final String CONFIDENTIAL = "Sunyk Project CONFIDENTIAL";

  /**
   * 复制模板模型.
   */
  @Autowired
  private RetryTemplate retryTemplate;

  /**
   * 重试处理.
   * @param proceedingJoinPoint 实际执行的处理
   * @return 任意对象
   * @throws Throwable 例外
   */
  @Around("execution(* com.syk.user.service.*.*Interface.*(..))")
  public Object retryFunctionIfThrowsDatabaseException(
      ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Object result = this.retryTemplate.execute(context -> {
      return proceedingJoinPoint.proceed();
    });

    return result;
  }
}
