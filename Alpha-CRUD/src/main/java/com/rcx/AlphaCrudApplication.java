package com.rcx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AlphaCrudApplication {
	
	private static Logger logger=LoggerFactory.getLogger(AlphaCrudApplication.class);

	public static void main(String[] args) {
		logger.debug("Application started");
		logger.info("IOC container created");
		SpringApplication.run(AlphaCrudApplication.class, args);
		
	}// end of main(-)

}// end of class
