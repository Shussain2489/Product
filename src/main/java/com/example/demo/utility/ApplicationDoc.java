package com.example.demo.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {

	Contact contact() {
		return new Contact().email("edreeee").name("Hussain").url("Hussain.com");
	}
	
	@Bean
	Info info() {
		return new Info ().title("Product Management System")
				.description("RESTful ")
				.version("v1");
	}
	
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info().contact(contact()));
	}
	
}
