 package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import com.example.demo.utility.ErrorStructure;
import com.example.demo.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {
	
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	@Operation(description = "The End Point is used to save a new product to the database", responses = {
			@ApiResponse(responseCode = "200",description = "Product saved Successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid Input")
	})
	@PostMapping(value= "/Products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
		
	}
	
	@Operation(description = "The End Point is used to delete a product from the database", responses = {
			@ApiResponse(responseCode = "200", description = "A product deleted successfully"),
			@ApiResponse(responseCode = "202", description = "The server successfully processed the request, but is not returning any content"),
			@ApiResponse(responseCode = "400", description = "Bad resquest"), //we can add as many as possible error responses.
	})
	@DeleteMapping(value= "/Products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int productId) {
		return service.deleteProduct(productId);
		
	}
	
	@Operation(description = "The End Point is used to delete a product from the database", responses = {
	@ApiResponse(responseCode = "200", description = "A product deleted successfully"),
	@ApiResponse(responseCode = "403", description = "Authentication failure or invalid Application ID"),
	@ApiResponse(responseCode = "400", description = "Bad request")//we can add as many as possible error responses.
	})
	@PutMapping(value= "/Products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int productId, @RequestBody Product product) {
		return service.updateProduct(productId, product);
		
	}
	
	@Operation(description="The End point is used to find a product by ID", responses = {
			@ApiResponse(responseCode = "200",description = "Product Found !"),
			@ApiResponse(responseCode = "404",description = "Product Not Found for the given ID", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping(value= "/Products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int productId) {
		return service.findById(productId);
		
	}
	
	@Operation(description="The End point is used to find all the products available in the database.", responses = {
			@ApiResponse(responseCode = "200",description = "List of products found"),
			@ApiResponse(responseCode = "404",description = "No product found", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping(value= "/Products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		return service.findAll();
		
	}
}
