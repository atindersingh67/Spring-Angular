package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The DemoApplication is a class which contain main method to boot the
 * application
 *
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 */

@Configuration
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
