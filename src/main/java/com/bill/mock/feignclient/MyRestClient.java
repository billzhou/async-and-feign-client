package com.bill.mock.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bill.mock.configuration.WmsAllocationConfiguration2;

@FeignClient(name="my-rest",configuration = WmsAllocationConfiguration2.class)
public interface MyRestClient {
	@RequestMapping(value = "/")
	String hello();
}
