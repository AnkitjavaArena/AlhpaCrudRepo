package com.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BetaConsumerSpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaConsumerSpringBootMvcApplication.class, args);
	}//end of main(-)

}//end of class
