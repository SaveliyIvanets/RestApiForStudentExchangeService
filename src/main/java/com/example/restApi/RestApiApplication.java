package com.example.restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {
	private com.example.restApi.JwtTokenSecuritySettings.JwtCore JwtCore;


	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
