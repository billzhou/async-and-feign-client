package com.bill.mock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockService {
	
	private static final Logger logger = LoggerFactory.getLogger(MockService.class);
	
	@Autowired
	AsyncService asyncService;
	
	public void mockMethod1(){
		logger.info("mockMethod1");
		this.asyncService.asyncMethod();
	}
	
	public void mockMethod2(){
		logger.info("mockMethod2");
	}

}
