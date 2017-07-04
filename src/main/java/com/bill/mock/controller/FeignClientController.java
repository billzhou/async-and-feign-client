package com.bill.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.mock.feignclient.AllocationClient;
import com.bill.mock.feignclient.MyRestClient;

@RestController
public class FeignClientController {
	@Autowired
	AllocationClient client;
	
	@Autowired
	MyRestClient helloClientTest;
	
	@RequestMapping("/my-rest")
	public String helloT() {
//		Object o = appContext.getBean("feignContext");
		return helloClientTest.hello();
//		FeignContext c = (FeignContext) o;
////		c.
//		return "dsd";
	}
	
	@RequestMapping("/allocation")
	public String hello() {
//		return "ds";
		
		return client.allocation();
//		return config.getUsername();
	}

}
