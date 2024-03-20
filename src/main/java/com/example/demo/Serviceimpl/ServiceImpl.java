package com.example.demo.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ProductNotFoundByIdException;
import com.example.demo.utility.ResponseStructure;

@Service
public class ServiceImpl implements ProductService{

	private ProductRepository productRepo;
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> structureList;
	

	public ServiceImpl(
			ProductRepository productRepo,
			ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> structureList){
		this.productRepo = productRepo;
		this.structure=structure;
		this.structureList=structureList;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		
		Product product2 = productRepo.save(product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product Object Saved Successfully !");
		responseStructure.setData(product2);
//		
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		
//		Product product2 = productRepo.save(mapToProduct(product));
//		return ResponseEntity.ok(
//				structure.setStatusCode(HttpStatus.OK.value()).setMessage("Product Saved Successfully")
//				.setData(product2));
	}

//	private Product mapToProduct(Product product) {
//		return
//	
//	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, Product updateProduct) {
		return productRepo.findById(productId).map(exProduct -> {
			updateProduct.setProductId(exProduct.getProductId());
			productRepo.save(updateProduct);
			return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product Object Updated Successfully")
					.setData(exProduct));
		}).orElseThrow(() -> new ProductNotFoundByIdException("No Product for the given Id is found"));
		
//		Optional<Product> optional = productRepo.findById(productId);                
//		if(optional.isPresent()) {
//			Product existingProduct = optional.get();
//			updateProduct.setProductId(existingProduct.getProductId());
//			
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Product Object Updated Successfully !");
//			responseStructure.setData(productRepo.save(updateProduct));
//			
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
//		}
//		return null;
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
//		Optional<Product> optional = productRepo.findById(productId);
//		if(optional.isPresent()) {
//			Product product = optional.get();
//			
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.CREATED.value());
//			responseStructure.setMessage("Product Object Deleted Successfully !");
//			responseStructure.setData(product);
//			productRepo.delete(product);
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
//		}
//		else 
//			return null;
		
		return productRepo.findById(productId).map(p->{
			productRepo.delete(p);
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product  deleted sucessfully  !")
					.setData(p));}).orElseThrow(()->new ProductNotFoundByIdException("Product Not Found for the given Id"));
	}

//	finding object using lambda expression 
	@Override
	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
		
		return productRepo.findById(productId).map(p->{
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
				.setMessage("Product Object Found !")
				.setData(p));}).orElseThrow(()->new ProductNotFoundByIdException("Product Not Found for the given Id"));
 	}

	
//	response Structure
//	@Override
//	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
//		Optional<Product> optional = productRepo.findById(productId);
//		if(optional.isPresent()) {
//			Product product = optional.get();
//			
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Product Object Found Successfully !");
//			responseStructure.setData(product);
//			
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
//		}
//		else {
//			throw new ProductNotFoundByIdException("Product Not Found :( ");
//		}
//		
// 	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		
		List<Product> list = productRepo.findAll();
		if(!list.isEmpty()) {
			return ResponseEntity.ok(
					structureList.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product Objects Found Successfully !")
					.setData(list)
					);
		}else throw new ProductNotFoundByIdException("Product Ojbects Not Found");
	}
//		List<Product> list = productRepo.findAll();
//		if(list!=null) {
//			ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.OK.value());
//			responseStructure.setMessage("Product Objects Found Successfully !");
//			responseStructure.setData(list);
//			
//			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.OK);
//		}
//		else {
//		return null;
//		}
		
	}
	


