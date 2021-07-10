// /**
//  * ServiceConfiguration.java
//  * 
//  * All Rights Reserved,
//  * Copyright 2021 Techno Project Japan Co.
//  */
// package com.example.demo.config;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.dao.DataAccessException;
// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.dao.DataRetrievalFailureException;
// import org.springframework.dao.DuplicateKeyException;
// import org.springframework.dao.IncorrectResultSizeDataAccessException;
// import org.springframework.dao.InvalidDataAccessApiUsageException;
// import org.springframework.dao.InvalidDataAccessResourceUsageException;
// import org.springframework.dao.OptimisticLockingFailureException;
// import org.springframework.dao.PermissionDeniedDataAccessException;
// import org.springframework.dao.PessimisticLockingFailureException;
// import org.springframework.dao.TypeMismatchDataAccessException;
// import org.springframework.jdbc.BadSqlGrammarException;
// import org.springframework.jdbc.IncorrectResultSetColumnCountException;
// import org.springframework.jdbc.datasource.init.ScriptException;
// import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
// import org.springframework.retry.annotation.EnableRetry;
// import org.springframework.retry.backoff.ExponentialBackOffPolicy;
// import org.springframework.retry.policy.SimpleRetryPolicy;
// import org.springframework.retry.support.RetryTemplate;

// @EnableRetry
// @Configuration
// public class ServiceConfiguration {
//   /**
//    * All Rights Reserved, <br />
//    * Copyright 2021 Techno Project Japan Co.
//    */
//   public static final String COPYRIGHT = "Copyright 2021 Techno Project Japan Co.";

//   /**
//    * Techno Project CONFIDENTIAL.
//    */
//   public static final String CONFIDENTIAL = "Techno Project CONFIDENTIAL";

//   /**
//    * リトライ実行可能な最大回数.
//    */
//   @Value("${jp.co.tpj.backendcomponent.service.retry-maxcount}")
//   private int retryMaxAttempts;

//   /**
//    * リトライの待機時間の初期値.
//    */
//   @Value("${jp.co.tpj.backendcomponent.service.exponentialbackoff-initialinterval}")
//   private int backOffInitialInterval;

//   /**
//    * リトライの対象外とする例外のリスト.
//    */
//   private List<Class<? extends Throwable>> notRetryableExceptions = Arrays.asList(
//       DuplicateKeyException.class,
//       DataSourceLookupFailureException.class,
//       DataIntegrityViolationException.class,
//       DataRetrievalFailureException.class,
//       InvalidDataAccessApiUsageException.class,
//       IncorrectResultSetColumnCountException.class,
//       IncorrectResultSizeDataAccessException.class,
//       InvalidDataAccessResourceUsageException.class,
//       BadSqlGrammarException.class,
//       OptimisticLockingFailureException.class,
//       PermissionDeniedDataAccessException.class,
//       PessimisticLockingFailureException.class,
//       TypeMismatchDataAccessException.class,
//       ScriptException.class
//   );
  
//   /**
//    * リトライ機能のテンプレートをBean登録する.
//    * @return
//    */
//   @Bean
//   public RetryTemplate retryTemplate() {
//     // リトライする例外を定義する
//     Map<Class<? extends Throwable>, Boolean> retryableExceptions = this.notRetryableExceptions
//         .stream()
//         .collect(Collectors.toMap(t -> t, t -> false));
//     retryableExceptions.put(DataAccessException.class, true);

//     // リトライポリシーの作成
//     SimpleRetryPolicy retryPolicy
//         = new SimpleRetryPolicy(this.retryMaxAttempts, retryableExceptions);

//     // リトライ待機時間の定義
//     ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
//     backOffPolicy.setInitialInterval(this.backOffInitialInterval);
//     RetryTemplate retryTemplate = new RetryTemplate();
//     retryTemplate.setRetryPolicy(retryPolicy);
//     retryTemplate.setBackOffPolicy(backOffPolicy);
//     return retryTemplate;
//   }
// }
