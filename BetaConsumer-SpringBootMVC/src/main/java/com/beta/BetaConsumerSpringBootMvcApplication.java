package com.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@LoadBalancerClients
public class BetaConsumerSpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaConsumerSpringBootMvcApplication.class, args);
	}//end of main(-)

}//end of class
