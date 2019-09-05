package com.serendipity.cloud.provider.webflux.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * HelloController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-26 15:30
 * Modified by:
 */
@RestController
public class HelloController {
	
	@GetMapping
	public Mono<String> hello() {
		return Mono.just("WelCome to reactive world!");
	}
	
}
