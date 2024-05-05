package com.warehouse.management.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.product.dto.ProductCreateDto;
import com.warehouse.management.product.service.ProductApiService;
import com.warehouse.management.utility.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class ProductApiController {
	
	@Autowired
	private ProductApiService productApiService;

	
	@PostMapping("/product")
	public ResponseEntity<Object> createProduct(@RequestBody ProductCreateDto productCreateDto){
//		System.out.println(productCreateDto);
//		return new ApiResponse().response();
		return productApiService.createProduct(productCreateDto);
	}
	
}
