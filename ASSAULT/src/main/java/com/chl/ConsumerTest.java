package com.chl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chl.service.BasicService;

public class ConsumerTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");
		context.start();
		BasicService bs = (BasicService)context.getBean("basicService");
		System.out.println(bs.sayHello("nono", "亚克西"));
	}

}
