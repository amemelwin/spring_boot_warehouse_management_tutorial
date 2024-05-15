package com.warehouse.management.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.customer.dto.CustomerCreateDto;
import com.warehouse.management.customer.service.CustomerApiService;

@RestController
@RequestMapping("/api/v1")

public class CustomerApiController {
	
	@Autowired
	private CustomerApiService customerApiService;
	
	@PostMapping("/customer")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerCreateDto customerCreateDto){
		return customerApiService.createCustomer(customerCreateDto);
	} 
	
	@PutMapping("/customer/{customerId}")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerCreateDto customerCreateDto,@PathVariable("customerId") long customerId){		
		customerCreateDto.setCustomerId(customerId);
		return customerApiService.updateCustomer(customerCreateDto);
	}
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable long customerId){
		return customerApiService.deleteCustomer(customerId);
	}

}
