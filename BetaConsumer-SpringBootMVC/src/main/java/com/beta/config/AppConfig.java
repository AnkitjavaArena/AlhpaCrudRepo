package com.beta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}// end of method
	
	@Bean
	public ObjectMapper createMapper() {
		return new ObjectMapper();
	}

}// end of class
