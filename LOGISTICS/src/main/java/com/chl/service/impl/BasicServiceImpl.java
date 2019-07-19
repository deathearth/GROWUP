package com.chl.service.impl;

import org.springframework.stereotype.Service;

import com.chl.service.BasicService;

@Service("basicService")
public class BasicServiceImpl implements BasicService {

	@Override
	public String sayHello(String username,String greeting) {
		return "来自"+username+"的问候：" + greeting;
	}

}
