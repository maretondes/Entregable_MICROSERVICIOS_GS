package com.mx.searchuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SearchuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchuserApplication.class, args);
	}

}
