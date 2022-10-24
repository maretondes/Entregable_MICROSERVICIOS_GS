package com.mx.searchemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SearchemailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchemailApplication.class, args);
	}

}
