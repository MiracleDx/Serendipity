package com.serendipity.cloud.consumer.feign.web;

import com.serendipity.cloud.consumer.feign.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ConsumerController
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-30 9:53
 * Modified by:
 */
@Slf4j
@RestController
public class ConsumerController {
	
	@Resource
	private HelloService helloService;

	@GetMapping("/consumer-feign")
	public String helloConsumer() {
		log.info("call feign client");
		return helloService.helloService();
	}

}
