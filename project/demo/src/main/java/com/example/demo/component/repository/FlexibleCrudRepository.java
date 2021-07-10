// /**
//  * FlexibleCrudRepository.java
//  *
//  * All Rights Reserved,
//  * Copyright 2021 Techno Project Japan Co.
//  */
// package com.example.demo.component.repository;

// import java.util.Collection;
// import java.util.Map;

// import jp.co.tpj.backendcomponent.model.SqlConditionModelInterface;

// /**
//  * Backendのリポジトリ処理の共通化インターフェース.
//  */
// public interface FlexibleCrudRepository<T> {
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
//    * 可変条件の検索処理(文字列の場合は部分一致検索)を実装します.
//    *
//    * @param type            結果リストに使用するクラスの指定
//    * @param serachCondition 検索条件(Tに一致したフィールド名で絞り込みする)
//    * @return 検索結果
//    */
//   Collection<T> searchByPartialMatch(
//       Class<T> type, final SqlConditionModelInterface serachCondition);

//   /**
//    * 可変条件の検索処理を実装します.
//    *
//    * @param type            結果リストに使用するクラスの指定
//    * @param searchCondition 検索条件(Tに一致したフィールド名で絞り込みする)
//    * @return 検索結果
//    */
//   Collection<T> search(Class<T> type, final SqlConditionModelInterface searchCondition);

//   /**
//    * レコードを挿入して IDを取得する. (idを持たないテーブルでは使用できない)
//    *
//    * @param entity レコード
//    * @return idの値
//    */
//   Number createAndReturnId(T entity);

//   /**
//    * レコードを挿入する.
//    *
//    * @param entity レコード
//    */
//   void create(T entity);

//   /**
//    * レコードを更新する.
//    * @param entity レコード
//    */
//   public void update(T entity);

//   /**
//    * 特定のインスタンスに対しカラムを指定して更新する.
//    * @param entity 更新対象のエンティティ
//    * @param updateValues 更新値
//    */
//   public void update(T entity, Map<String, Object> updateValues);

//   /**
//    * レコードをまとめて更新する.
//    * @param entities 更新レコードのコレクション
//    */
//   public void updateAll(Collection<T> entities);

//   /**
//    * 条件を指定してUPDATE文を実行する.
//    * @param type 更新するテーブルのエンティティ
//    * @param whereValues 更新対象のレコードの条件
//    * @param updateValues 更新値
//    */
//   public void updateAll(
//       Class<T> type, Map<String, Object> whereValues, Map<String, Object> updateValues);

//   /**
//    * 条件を指定してDELETE文を実行する.
//    * @param type レコードを削除するテーブルのエンティティ
//    * @param condition 削除条件
//    */
//   public void delete(Class<T> type, Object condition);
// }
