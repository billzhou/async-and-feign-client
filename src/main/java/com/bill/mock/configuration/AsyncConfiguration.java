package com.bill.mock.configuration;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/*
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html
 * The main idea is that when a task is submitted, the executor will first try to use a free thread if the number of active threads is currently less than the core size. 
 * If the core size has been reached, then the task will be added to the queue as long as its capacity has not yet been reached. Only then, 
 * if the queue’s capacity has been reached, will the executor create a new thread beyond the core size. If the max size has also been reached, then the executor will reject the task.
 * 
 * keep-alive setting determines the time limit (in seconds) for which threads may remain idle before being terminated. 
 * If there are more than the core number of threads currently in the pool, after waiting this amount of time without processing a task, excess threads will get terminated. 
 */

@EnableAsync
@Configuration
@ConfigurationProperties(prefix = "com.bill.async")
public class AsyncConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(AsyncConfiguration.class);
	
	private int corePoolSize = 10;
	private int maxPoolSize = 50;
	//By default, the queue is unbounded, but this is rarely the desired configuration, because it can lead to OutOfMemoryErrors if enough tasks are added to that queue while all pool threads are busy.
	private int queueCapacity = 1000;
	private String threadNamePrefix = "Bill-Exec-";
	
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	public String getThreadNamePrefix() {
		return threadNamePrefix;
	}

	public void setThreadNamePrefix(String threadNamePrefix) {
		this.threadNamePrefix = threadNamePrefix;
	}
	

}
