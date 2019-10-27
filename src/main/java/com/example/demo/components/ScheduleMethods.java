package com.example.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMethods {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduleMethods.class);
	private int i = 0;
	
	//All scheduled methods should have void as return type and accept no arguments
	@Scheduled(fixedRate = 1000)
	public void scheduleTaskWithFixedRate() throws InterruptedException {
		sleepMethod(++i);
		logger.info("Fixed Rate Task " + i + " completed");
	}
	
	@Scheduled(fixedDelay = 2000)
	public void scheduleTaskWithFixedDelay() throws InterruptedException {
		sleepMethod(++i);
		logger.info("Fixed Delay Task " + i + " completed");
	}	
	
	@Scheduled(initialDelay =  2000, fixedRate = 1000)
	public void scheduleTaskWithInitialDelay() {
		logger.info("Fixed rate with initial delay task " + ++i + " execution");
	}
	
	@Scheduled(cron = "0/3 * * * * ?")
	public void scheduleTaskWithCronExpression() {
		logger.info("Scheduled task with cron expression " + ++i + " execution" + Thread.currentThread());
	}

	public void sleepMethod(int i) throws InterruptedException {
		logger.info("Inside scheduled task " + i + " execution");
		Thread.sleep(2000);		
	}
}
