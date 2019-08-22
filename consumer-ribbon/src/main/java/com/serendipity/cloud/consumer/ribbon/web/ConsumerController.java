package com.serendipity.cloud.consumer.ribbon.web;

import com.serendipity.cloud.consumer.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ConsumerController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-23 10:32
 * Modified by:
 */
@RestController
public class ConsumerController {
		
	@Resource
	private HelloService helloService;
	
	@GetMapping("/consumer-ribbon")
	public String helloConsumer() {
		return helloService.helloService();
	}
}
