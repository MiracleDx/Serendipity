package com.serendipity.cloud.consumer.feign.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageRestController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-05 11:09
 * Modified by:
 */
@RefreshScope
@RestController
public class MessageRestController {
	
	@Value("${message:Hello default}")
	private String message;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String foo;
	
	@RequestMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@RequestMapping("/foo")
	public String hi() {
		return foo;
	}
	
}
