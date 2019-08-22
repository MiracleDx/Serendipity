package com.serendipity.cloud.provider.hello.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * HelloController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-23 10:02
 * Modified by:
 */
@Slf4j
@RestController
public class HelloController {

	@Resource
	private Registration registration;
	
	@Resource
	private DiscoveryClient client;
	
	@GetMapping("/hello")
	public String index() {
		int sleepTime = new Random().nextInt(6000);
		log.info("sleepTime:{}", sleepTime);
		//try {
			//Thread.sleep(sleepTime);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		log.info("/hello, host:{}, service_id:{}", registration.getHost(), registration.getServiceId());
		return "Hello World";
	}
}
