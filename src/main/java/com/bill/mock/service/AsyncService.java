package com.bill.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Autowired 
	MockService mockService;
	
	@Async
	public void asyncMethod(){
		mockService.mockMethod2();
	}
	
}
