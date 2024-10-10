package com.example.FixedStrikeVolatility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class, serves as the entry point.
 * @SpringBootApplication adds @Configuration, @EnableAutoConfiguration, @ComponentScan
 * @Configuration tags this class as the source of bean definitions
 * @EnableAutoConfiguration adds beans based on classpath settings
 * @ComponentScan commands SpringBoot to search for other components and services in the package
 */
@SpringBootApplication
public class FixedStrikeVolatilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixedStrikeVolatilityApplication.class, args);
	}

}
