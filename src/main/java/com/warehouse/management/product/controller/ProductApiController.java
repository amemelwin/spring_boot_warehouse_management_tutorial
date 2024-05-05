package com.warehouse.management.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.product.dto.ProductCreateDto;
import com.warehouse.management.product.service.ProductApiService;

@RestController
@RequestMapping("/api/v1")
public class ProductApiController {
	
	@Autowired
	private ProductApiService productApiService;

	
	@PostMapping("/product")
	public ResponseEntity<Object> createProduct(@RequestBody ProductCreateDto productCreateDto){
		return productApiService.createProduct(productCreateDto);
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductCreateDto productCreateDto,@PathVariable long productId){
		productCreateDto.setProductId(productId);
		System.out.println(productCreateDto);
		return productApiService.updateProduct(productCreateDto);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long productId){
		return productApiService.deleteProduct(productId);
	}
	
}
