package com.mont.rasmooplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableCaching
public class RasmooplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(RasmooplusApplication.class, args);
	}

}
