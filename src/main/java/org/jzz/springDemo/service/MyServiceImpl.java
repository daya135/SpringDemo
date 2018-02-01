package org.jzz.springDemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{

	@Override
	public void doService() {
		System.out.println("调用Myservice.doService()");
	}
	
}
