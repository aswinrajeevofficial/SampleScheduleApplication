package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class CustomThreadPool implements SchedulingConfigurer{

	private int POOL_SIZE = 10;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		
		taskScheduler.setPoolSize(POOL_SIZE);
		taskScheduler.setThreadNamePrefix("not-the-default-thread-pool");
		taskScheduler.initialize();
		
		taskRegistrar.setTaskScheduler(taskScheduler);
	}	
}
