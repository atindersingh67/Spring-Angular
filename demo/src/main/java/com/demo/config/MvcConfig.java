package com.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* The MvcConfig is a configuration class for all common configurations  
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
}
