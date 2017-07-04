package com.bill.mock.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bill.mock.configuration.WmsAllocationConfiguration;

@FeignClient(name="wms-allocation",configuration = WmsAllocationConfiguration.class)
public interface AllocationClient {
	@RequestMapping(value = "/wms-allocation")
	String allocation();
}