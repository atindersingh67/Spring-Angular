package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
* The SwaggerConfig is a configuration class for swagger  
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()                 .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
	                .paths(regex("/api.*"))
	                .build();
	    }
}
