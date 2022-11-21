package com.example.demo.config;

import java.util.Collections;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
/*
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

//@Configuration
/*
public class SwaggerDocsConfig {

	@Bean
public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // UI screen type
				.select() // to specify RestControllers
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // base pkg for RestContrllers
				.paths(PathSelectors.regex("/tourist.*")) // to specify request paths
				.build() // builds the Docket obj
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Admin", "http://www.google.com", "dummyMail@gmail.com");
		return new ApiInfo("Tourist API", "Gives Information about Tourist Activites", "4.5.RELEASE", "http://www.google.com/license",
				contact, "Alpha", "http://apache.org/license/alpha", Collections.emptyList());
	}*/

//}// end of class
