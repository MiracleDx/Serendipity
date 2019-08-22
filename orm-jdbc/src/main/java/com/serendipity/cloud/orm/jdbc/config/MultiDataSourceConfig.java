package com.serendipity.cloud.orm.jdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * MultiDataSourceConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 14:34
 * Modified by:
 */
@Configuration
public class MultiDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.foo")
	public DataSourceProperties fooDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "fooDataSource")
	public DataSource fooDataSource() {
		DataSourceProperties dataSourceProperties = fooDataSourceProperties();
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Resource
	public PlatformTransactionManager fooTxManager(DataSource fooDataSource) {
		return new DataSourceTransactionManager(fooDataSource);
	}

	@Bean("fooJdbcTemplate")
	public JdbcTemplate fooJdbcTemplate(DataSource fooDataSource) {
		return new JdbcTemplate(fooDataSource);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.bar")
	public DataSourceProperties barDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "barDataSource")
	public DataSource barDataSource() {
		DataSourceProperties dataSourceProperties = barDataSourceProperties();
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Resource
	public PlatformTransactionManager barTxManager(DataSource barDataSource) {
		return new DataSourceTransactionManager(barDataSource);
	}

	@Bean("barJdbcTemplate")
	public JdbcTemplate barJdbcTemplate(DataSource barDataSource) {
		return new JdbcTemplate(barDataSource);
	}
}
