package com.serendipity.cloud.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloService
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-30 9:47
 * Modified by:
 */
@FeignClient(name = "provider-hello", fallback = HelloServiceFallback.class)
public interface HelloService {
	
	@GetMapping("/hello")
	String helloService();
}
