package com.serendipity.cloud.consumer.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignConfig
 * Feign配置类
 * @author Dongx
 * Description:
 * Created in: 2019-07-30 14:11
 * Modified by:
 */
@Configuration
public class FeignConfig {
	
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
