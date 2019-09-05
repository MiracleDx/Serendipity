package com.serendipity.cloud.provider.webflux.config;

import com.serendipity.cloud.provider.webflux.common.TimeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.Resource;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * RouterConfig
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-26 17:06
 * Modified by:
 */
@Configuration
public class RouterConfig {
	
	@Resource
	private TimeHandler timeHandler;
	
	@Bean
	public RouterFunction<ServerResponse> timeRouter() {
		return route(GET("/time"), req -> timeHandler.getTime(req))
					.andRoute(GET("/date"), timeHandler::getDate)
					.andRoute(GET("/times"), timeHandler::sendTimePerSec);
	}
	
	
}
