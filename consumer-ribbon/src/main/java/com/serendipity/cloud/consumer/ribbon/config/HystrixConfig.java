package com.serendipity.cloud.consumer.ribbon.config;

import org.springframework.context.annotation.Configuration;

/**
 * HystrixConfig
 * Hystrix配置类
 * @author Dongx
 * Description:
 * Created in: 2019-07-29 16:31
 * Modified by:
 */
@Configuration
public class HystrixConfig {

	/**
	 * 暴露hystix监控端点
	 * @return
	 */
	//@Bean
	//public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
	//	HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	//	ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
	//	registrationBean.setLoadOnStartup(1);
	//  // 此路径可以自定义，一般按照DashBoard界面的提示填即可
	//	registrationBean.addUrlMappings("/actuator/hystrix.stream"); 
	//	registrationBean.setName("HystrixMetricsStreamServlet");
	//	return registrationBean;
	//}
}
