package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Product;
import com.example.demo.utility.ResponseStructure;

public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId,Product product );
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> findById(int productId) ;
	
	public ResponseEntity<ResponseStructure<List<Product>>> findAll();

	
	
}
