// package com.example.demo.config;

// import java.util.Arrays;

// import jp.co.tpj.backendcomponent.repository.OffsetDateTimeToTimestampConverter;
// import jp.co.tpj.backendcomponent.repository.TimestampToOffsetDateTimeConverter;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
// import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

// /**
//  * Spring JDBCの設定拡張クラス. DB⇔Model間の独自の型変換を追加する。
//  */
// @Configuration
// public class JdbcCustomConfiguration extends AbstractJdbcConfiguration {
//   @Override
//   public JdbcCustomConversions jdbcCustomConversions() {
//     return new JdbcCustomConversions(Arrays.asList(
//         new TimestampToOffsetDateTimeConverter(), new OffsetDateTimeToTimestampConverter()));
//   }
// }
