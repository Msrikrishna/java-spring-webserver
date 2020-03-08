package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import info.bliki.api.Connector;
import info.bliki.api.TestUser;
import info.bliki.api.User;

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


	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}

	@Bean
	public Connector getConnector(){

		return new TestUser.TestConnector();
	}

	@Bean
	public User getUSer(){
		return new User(null, null, "https://en.wiktionary.org/w/api.php");
	}

}
