package com.vmware.demos.spring.cfg.compositecfgserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner doSomething(@Value("${foo:nofoo}")String foo, @Value("${bar:nobar}")String bar)	{

		return args ->	{
			
			LOGGER.info("Hello, my foo is {} and my bar is {}", foo, bar);
			
		};

	}
}
