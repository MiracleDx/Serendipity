package com.serendipity.cloud.orm.jpa.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * FooJpaConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-07 17:35
 * Modified by:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "fooEntityManagerFactory",
		transactionManagerRef = "fooTransactionManager",
		basePackages = {"com.serendipity.cloud.orm.jpa.repository.foo"}
)
public class FooJpaConfig {
	
	@Resource
	private DataSource fooDataSource;
	
	@Resource
	private JpaProperties jpaProperties;
	
	@Resource
	private HibernateProperties hibernateProperties;
	
	@Primary
	@Bean(name = "fooEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return fooEntityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Primary
	@Bean(name = "fooEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean fooEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder
				.dataSource(fooDataSource)
				.packages("com.serendipity.cloud.model.entity")
				.persistenceUnit("fooPersistenceUnit")
				.properties(getVendorProperties())
				.build();
		return entityManagerFactoryBean;
	}

	@Primary
	@Bean(name = "fooTransactionManager")
	public PlatformTransactionManager fooTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(fooEntityManagerFactory(builder).getObject());
	}

	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
	}
}

