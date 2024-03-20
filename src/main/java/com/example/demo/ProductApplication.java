package com.example.demo;

//import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.Product;

@SpringBootApplication 
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
		
//		Product product = new Product();
//		Optional.of(product).map(p->{System.out.println("Inside map"); 
//		return p;}).orElseThrow(()->new RuntimeException());
	}

}
