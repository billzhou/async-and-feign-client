package com.bill;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.mock.WmsAllocationConfiguration;
import com.bill.mock.WmsAllocationConfiguration2;
import com.bill.mock.service.MockService;


@EnableEurekaClient
@SpringBootApplication
@RestController
//@EnableDiscoveryClient
@EnableFeignClients
//@EnableAutoConfiguration
//@EnableConfigurationProperties
@EnableAsync
public class MyMockApplication {

	@Autowired
	private ApplicationContext appContext;
	
	public static void main(String[] args) {
		SpringApplication.run(MyMockApplication.class, args);
	}
	
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
	
	
	@Autowired
	HelloClient client;
	
	@Autowired
	HelloClientTest helloClientTest;
	
	@Autowired
	MockService mockService;

//	@Autowired
//	Config config;
	
	@RequestMapping("/test")
	public String helloT() {
//		Object o = appContext.getBean("feignContext");
		return helloClientTest.hello();
//		FeignContext c = (FeignContext) o;
////		c.
//		return "dsd";
	}
	
	@RequestMapping("/async")
	public String async(){
		mockService.mockMethod1();
		return "async";
	}
	
	@RequestMapping("/")
	public String hello() {
//		return "ds";
		
		return client.hello();
//		return config.getUsername();
	}

	@FeignClient(name="wms-allocation",configuration = WmsAllocationConfiguration.class)
	interface HelloClient {
		@RequestMapping(value = "/wms-allocation")
		String hello();
	}
	
	@FeignClient(name="my-rest",configuration = WmsAllocationConfiguration2.class)
	interface HelloClientTest {
		@RequestMapping(value = "/")
		String hello();
	}
}
