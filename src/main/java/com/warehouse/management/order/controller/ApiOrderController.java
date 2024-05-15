package com.warehouse.management.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.order.dto.OrderCreateDto;
import com.warehouse.management.order.service.OrderService;

@RestController
@RequestMapping("api/v1")
public class ApiOrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/customer/{customerId}/address")
	public ResponseEntity<Object> getCustomerDeliveryAddress(@PathVariable int customerId){
		return orderService.getCustomerDeliveryAddress(customerId);
	}
	
	@GetMapping("/address/{addressId}/products")
	public ResponseEntity<Object> getWarehouseProductOption(@PathVariable int addressId){
		return orderService.getWarehouseProductOption(addressId);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderCreateDto orderCreateDto){
		return orderService.createOrder(orderCreateDto);
	}
}
