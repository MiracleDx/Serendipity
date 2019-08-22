package com.serendipity.cloud.consumer.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * HelloService
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-23 16:48
 * Modified by:
 */
@Service
public class HelloService {
	
	@Resource
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		return restTemplate.getForEntity("http://PROVIDER-HELLO/hello", String.class).getBody();
	}
	
	public String helloFallback() {
		return "error";
	}
}
