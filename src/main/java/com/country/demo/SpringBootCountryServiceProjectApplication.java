package com.country.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootCountryServiceProjectApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootCountryServiceProjectApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCountryServiceProjectApplication.class, args);
	}

}
