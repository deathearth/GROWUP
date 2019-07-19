package com.chl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chl.service.BasicService;

/**
 * Hello world!
 *
 */
public class Run {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");
		BasicService bs = (BasicService) context.getBean("basicService");
		context.start();
		while(true) {
			
		}
	}
}
