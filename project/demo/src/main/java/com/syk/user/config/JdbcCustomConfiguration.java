package com.syk.user.config;

import java.util.Arrays;

import jp.co.tpj.backendcomponent.repository.OffsetDateTimeToTimestampConverter;
import jp.co.tpj.backendcomponent.repository.TimestampToOffsetDateTimeConverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

/**
 * Spring JDBC的设置扩展类。DB→Model之间添加自己的类型转换.
 */
@Configuration
public class JdbcCustomConfiguration extends AbstractJdbcConfiguration {
  @Override
  public JdbcCustomConversions jdbcCustomConversions() {
    return new JdbcCustomConversions(Arrays.asList(
        new TimestampToOffsetDateTimeConverter(), new OffsetDateTimeToTimestampConverter()));
  }
}
