package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class TestNgProjectApplication {

	//Running the main class , the args is passed from the configuration,which chooses the .properties file 
	public static void main(String[] args) {
		SpringApplication.run(TestNgProjectApplication.class, args);
	}
	
	//Registering RestTemplate class as a spring bean
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
