package com.serendipity.cloud.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	//@Bean
	//public RouteLocator router(RouteLocatorBuilder builder) {
	//	String httpUri = "http://localhost:8181/hello";
	//	return builder.routes()
	//			.route(p -> p
	//				.path("/hello")
	//				.filters(f -> f.addRequestHeader("Hello", "World"))
	//				.uri(httpUri))
	//			.route(p -> p
	//				.host("*.hystrix.com")
	//				.filters(f -> f
	//					.hystrix(config -> config
	//						.setName("mycmd")
	//						.setFallbackUri("forward:/fallback")))
	//				.uri(httpUri))
	//			.build();
	//}
	//
	//@RequestMapping("/fallback")
	//public Mono<String> fallback() {
	//	return Mono.just("fallback");
	//}
}
