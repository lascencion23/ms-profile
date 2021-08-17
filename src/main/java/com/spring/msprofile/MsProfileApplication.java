package com.spring.msprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProfileApplication.class, args);
	}

}
