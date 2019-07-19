package com.chl.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.chl.service.BasicService;
/**
 * 通过api的方式注册dubbo服务
 * @author chenhailong
 */
public class DubboConsumerApi {

	public void test() {
		//应用配置
		ApplicationConfig app = new ApplicationConfig();
		app.setName("provider");

		// 注册中西配置
		RegistryConfig rc = new RegistryConfig();
		rc.setAddress("127.0.0.1:2181");
		rc.setUsername("pro");
		rc.setPassword("vider");
		
		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
		// 服务消费
		ReferenceConfig<BasicService> ref = new ReferenceConfig<BasicService>();
		ref.setApplication(app);
		ref.setRegistry(rc);
		ref.setInterface(BasicService.class);
		
		//获取接口对象
		BasicService bs = ref.get();
		
	}
}
