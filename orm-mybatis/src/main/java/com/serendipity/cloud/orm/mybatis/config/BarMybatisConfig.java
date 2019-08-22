package com.serendipity.cloud.orm.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * BarMybatisConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-09 14:17
 * Modified by:
 */
@Configuration
@MapperScan(
		basePackages = {"com.serendipity.cloud.orm.mybatis.mapper.bar"},
		sqlSessionFactoryRef = "barSqlSessionFactory"
		//sqlSessionTemplateRef = "barSqlSessionTemplate"
		)
@Slf4j
public class BarMybatisConfig {
	
	@Resource
	private DataSource barDataSource;

	@Bean(name = "barSqlSessionFactory")
	public SqlSessionFactory barSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(barDataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/bar/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "barTransactionManager")
	public PlatformTransactionManager barTransactionManager() {
		return new DataSourceTransactionManager(barDataSource);
	}

	//@Primary
	//@Bean(name = "barSqlSessionTemplate")
	//public SqlSessionTemplate barSqlSessionTemplate() throws Exception {
	//	return new SqlSessionTemplate(barSqlSessionFactory());
	//}
}
