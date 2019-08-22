package com.serendipity.cloud.orm.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * FooMybatisConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-09 13:53
 * Modified by:
 */
@Configuration
@MapperScan(
		basePackages = {"com.serendipity.cloud.orm.mybatis.mapper.foo"}, 
		sqlSessionFactoryRef = "fooSqlSessionFactory"
		//sqlSessionTemplateRef = "fooSqlSessionTemplate"
		)
public class FooMybatisConfig {
	
	@Resource
	private DataSource fooDataSource;
	
	@Primary
	@Bean(name = "fooSqlSessionFactory")
	public SqlSessionFactory fooSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(fooDataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/foo/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name = "fooTransactionManager")
	public PlatformTransactionManager fooTransactionManager() {
		return new DataSourceTransactionManager(fooDataSource);
	}
	
	//@Primary
	//@Bean(name = "fooSqlSessionTemplate")
	//public SqlSessionTemplate fooSqlSessionTemplate() throws Exception {
	//	return new SqlSessionTemplate(fooSqlSessionFactory());
	//}
}
