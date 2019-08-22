package com.serendipity.cloud.server.zuul.config;

import com.serendipity.cloud.server.zuul.filter.AccessFilter;
import com.serendipity.cloud.server.zuul.filter.ErrorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ZuulConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-31 16:04
 * Modified by:
 */
@Configuration
public class ZuulConfig {
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
