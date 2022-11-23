package com.beta.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.beta.interceptors.RestServiceCheckInterceptor;
import com.beta.interceptors.RestServiceTimeCheckInterceptor;

@Component
public class BetaInterceptorRegistryConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("BetaInterceptorRegistryConfigurer.addInterceptors()");
		registry.addInterceptor(new RestServiceTimeCheckInterceptor());
	}// end of method

}// end of class
