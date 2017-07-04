package com.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class MyMockApplication {

	@Autowired
	private ApplicationContext appContext;
	
	public static void main(String[] args) {
		SpringApplication.run(MyMockApplication.class, args);
	}
}
