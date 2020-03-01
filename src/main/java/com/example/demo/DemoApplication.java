package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.*;
@SpringBootApplication
public class DemoApplication {

	final static Logger logger = LogManager.getLogger(DemoApplication.class);
	public static void main(String[] args) {

		//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Started app");
	}

}
