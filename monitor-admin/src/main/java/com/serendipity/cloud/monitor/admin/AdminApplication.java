package com.serendipity.cloud.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class AdminApplication {
	// todo 监控日志 接入更多端点
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
