package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SpringBootApplication
@EnableJpaAuditing

public class DemoApplication {
	
	final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(final String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		logger.info("Started app");
	}

}
