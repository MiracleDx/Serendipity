package com.serendipity.cloud.server.eureka;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * EurekaStateChangeListener
 * 服务上下线监控
 * @author Dongx
 * Description:
 * Created in: 2019-07-29 15:05
 * Modified by:
 */
@Component
public class EurekaStateChangeListener {
	
	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + "  服务下线");
	}

	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		InstanceInfo instanceInfo = event.getInstanceInfo();
		System.err.println(instanceInfo.getAppName() + "  进行注册");
	}

	@EventListener
	public void listen(EurekaInstanceRenewedEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + "  服务续约");
	}

	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		System.err.println("注册中心 启动");
	}

	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		System.err.println("Eureka Server 启动");
	}
	
}
