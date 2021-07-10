// /**
//  * ServiceRetryAspect.java
//  * 
//  * All Rights Reserved,
//  * Copyright 2021 Techno Project Japan Co.
//  */
// package com.example.demo.component.service;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.retry.support.RetryTemplate;
// import org.springframework.stereotype.Component;

// /**
//  * Serviceの各処理にリトライに関するアスペクトを挿入するクラス.
//  */
// @Aspect
// @Component
// public class ServiceRetryAspect {
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
//    * リトライテンプレートモデル.
//    */
//   @Autowired
//   private RetryTemplate retryTemplate;

//   /**
//    * リトライ処理.
//    * @param proceedingJoinPoint 実際に実行する処理
//    * @return 任意のオブジェクト
//    * @throws Throwable 例外
//    */
//   @Around("execution(* jp.co.tpj.organization.backend.domain.service.*.*Interface.*(..))")
//   public Object retryFunctionIfThrowsDatabaseException(
//       ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//     Object result = this.retryTemplate.execute(context -> {
//       return proceedingJoinPoint.proceed();
//     });

//     return result;
//   }
// }
