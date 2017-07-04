package com.bill.mock.configuration;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

//@Configuration
@ConfigurationProperties(prefix="microservice")
public class WmsAllocationConfiguration2 {
//	@NotEmpty
//	public String username;
//	@NotEmpty
//	public String password;
	
	@Autowired
	Config config;
	
//	This way worked
	public String password = "testpass";
	
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("testuser", "testpass");//this.password);
//		return new BasicAuthRequestInterceptor(this.getUsername(), this.getPassword());
//		return new BasicAuthRequestInterceptor(config.getUsername(), config.getPassword());
    }
	
}
