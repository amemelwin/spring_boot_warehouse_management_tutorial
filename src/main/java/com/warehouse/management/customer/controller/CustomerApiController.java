package com.warehouse.management.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.customer.dto.CustomerCreateDto;
import com.warehouse.management.customer.service.CustomerApiService;
import com.warehouse.management.utility.ApiResponse;

@RestController
@RequestMapping("/api/v1")

public class CustomerApiController {
	
	@Autowired
	private CustomerApiService customerApiService;
	
	@PostMapping("/customer")
	public ResponseEntity<Object> createProduct(@RequestBody CustomerCreateDto customerCreateDto){
		return customerApiService.createCustomer(customerCreateDto);
	} 

}
