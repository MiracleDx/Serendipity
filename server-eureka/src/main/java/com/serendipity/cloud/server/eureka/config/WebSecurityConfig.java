package com.serendipity.cloud.server.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * WebSecurityConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-12 10:23
 * Modified by:
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/eureka/**");
		super.configure(http);
	}
}
