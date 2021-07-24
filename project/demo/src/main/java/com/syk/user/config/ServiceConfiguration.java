
/**
* ServiceConfiguration.java
*
* All Rights Reserved,
* Copyright 2021 By syk.
*/

package com.syk.user.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@EnableRetry
@Configuration
public class ServiceConfiguration {
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
  * 可重试的最大次数.
  */
  @Value("${com.syk.backendcomponent.service.retry-maxcount}")
  private int retryMaxAttempts;

  /**
  * 重试待机时间的初始值.
  */
  @Value("${com.syk.backendcomponent.service.exponentialbackoff-initialinterval}")
  private int backOffInitialInterval;

  /**
   * 不属于重试对象的例外列表.
   */
  private List<Class<? extends Throwable>> notRetryableExceptions = Arrays.asList(
      DuplicateKeyException.class,
      DataSourceLookupFailureException.class,
      DataIntegrityViolationException.class,
      DataRetrievalFailureException.class,
      InvalidDataAccessApiUsageException.class,
      IncorrectResultSetColumnCountException.class,
      IncorrectResultSizeDataAccessException.class,
      InvalidDataAccessResourceUsageException.class,
      BadSqlGrammarException.class,
      OptimisticLockingFailureException.class,
      PermissionDeniedDataAccessException.class,
      PessimisticLockingFailureException.class,
      TypeMismatchDataAccessException.class,
      ScriptException.class
  );

  /**
   * Bean注册重试功能模板.
   * @return RetryTemplate
   */
  @Bean
  public RetryTemplate retryTemplate() {
    // 定义重试的例外
    Map<Class<? extends Throwable>, Boolean> retryableExceptions = this.notRetryableExceptions
        .stream()
        .collect(Collectors.toMap(t -> t, t -> false));
    retryableExceptions.put(DataAccessException.class, true);

    // 创建重试策略
    SimpleRetryPolicy retryPolicy
        = new SimpleRetryPolicy(this.retryMaxAttempts, retryableExceptions);

    // 定义重试等待时间
    ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
    backOffPolicy.setInitialInterval(this.backOffInitialInterval);
    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setRetryPolicy(retryPolicy);
    retryTemplate.setBackOffPolicy(backOffPolicy);
    return retryTemplate;
  }
}
