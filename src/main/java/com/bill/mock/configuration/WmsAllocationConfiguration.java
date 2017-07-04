package com.bill.mock.configuration;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

//@Configuration
@ConfigurationProperties(prefix="microservice")
public class WmsAllocationConfiguration {
	
	@Autowired
	Config config;

	@Bean
    public BasicAuthRequestInterceptor allocationAuthRequestInterceptor() {
		//Wrong pass to show we have different configuration for allocation and my rest feign clients
		return new BasicAuthRequestInterceptor(config.getUsername(), "testpas");
    }
	
}
