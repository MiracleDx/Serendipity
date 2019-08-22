package com.serendipity.cloud.server.zuul.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-31 15:05
 * Modified by:
 */
@RestController
@RequestMapping("/local")
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World Local";
	}
}
