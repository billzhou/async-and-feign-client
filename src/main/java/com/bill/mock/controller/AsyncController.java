package com.bill.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.mock.service.MockService;

@RestController
public class AsyncController {

	@Autowired
	MockService mockService;
	
	@RequestMapping("/async")
	public String async(){
		mockService.mockMethod1();
		return "async";
	}
}
