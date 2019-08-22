package com.serendipity.cloud.consumer.feign.service;

import org.springframework.stereotype.Component;

/**
 * HelloServiceFallback
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-30 10:42
 * Modified by:
 */
@Component
public class HelloServiceFallback implements HelloService {
	
	@Override
	public String helloService() {
		return "read time out error";
	}
}
