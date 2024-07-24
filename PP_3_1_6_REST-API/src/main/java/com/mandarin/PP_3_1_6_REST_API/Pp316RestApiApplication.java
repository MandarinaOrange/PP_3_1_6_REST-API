package com.mandarin.PP_3_1_6_REST_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Pp316RestApiApplication {


	public Pp316RestApiApplication()  {
	}

	public static void main(String[] args)  {
		SpringApplication.run(Pp316RestApiApplication.class, args);

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}





}



















