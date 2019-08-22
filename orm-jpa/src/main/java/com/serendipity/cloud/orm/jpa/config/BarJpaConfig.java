package com.serendipity.cloud.orm.jpa.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * BarJpaConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-08 9:22
 * Modified by:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "barEntityManagerFactory",
		transactionManagerRef = "fooTransactionManager",
		basePackages = {"com.serendipity.cloud.orm.jpa.repository.bar"}
)
public class BarJpaConfig {
	
	@Resource
	private DataSource barDataSource;
	
	@Resource
	private JpaProperties jpaProperties;
	
	@Resource
	private HibernateProperties hibernateProperties;
	
	@Bean(name = "barEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return barEntityManagerFactory(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "barEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder
				.dataSource(barDataSource)
				.packages("com.serendipity.cloud.model.entity")
				.persistenceUnit("barPersistenceUnit")
				.properties(getVendorProperties())
				.build();
		return entityManagerFactoryBean;
	}

	@Bean(name = "barTransactionManager")
	public PlatformTransactionManager barTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(barEntityManagerFactory(builder).getObject());
	}
	
	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
	}
}
