package com.chl.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.chl.service.BasicService;
import com.chl.service.impl.BasicServiceImpl;

/**
 * 通过api的方式注册dubbo服务
 * @author chenhailong
 */
public class DubboRegistryApi {
	
	public void reg() {
		BasicService bs = new BasicServiceImpl();
		
		//应用配置
		ApplicationConfig app = new ApplicationConfig();
		app.setName("provider");

		// 注册中西配置
		RegistryConfig rc = new RegistryConfig();
		rc.setAddress("127.0.0.1:2181");
		rc.setUsername("pro");
		rc.setPassword("vider");
		
		// 服务提供方全局超时配置
		ProviderConfig pc = new ProviderConfig();
		pc.setTimeout(5 * 1000);
		
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setPort(20881);
		protocol.setName("dubb");
		protocol.setThreads(200);
		
		// 服务提供者暴露服务配置
		ServiceConfig<BasicService> sc = new ServiceConfig<BasicService>();
		sc.setApplication(app);
		sc.setRegistry(rc);
		sc.setProvider(pc);
		sc.setProtocol(protocol);
		
		sc.setInterface(bs.getClass());
		sc.setRef(bs);
		sc.setVersion("1.0.0");
		// 暴露及注册服务
		sc.export();
	}
}
