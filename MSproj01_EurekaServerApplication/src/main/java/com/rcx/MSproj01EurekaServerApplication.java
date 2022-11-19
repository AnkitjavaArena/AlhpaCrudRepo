package com.rcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     //annotation to activate eureka server related configuration Eurekaserver
public class MSproj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSproj01EurekaServerApplication.class, args);
	}//end of main

}//end of class
