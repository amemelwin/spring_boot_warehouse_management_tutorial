package com.warehouse.management.order.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.order.dto.OrderCreateDto;
import com.warehouse.management.order.dto.OrderDetailCreateDto;
import com.warehouse.management.order.service.OrderService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1")
public class ApiOrderController {

	@Autowired
	private OrderService orderService;
	
//	@PostConstruct
//	public void init() {
//		OrderCreateDto orderCreateDto = new OrderCreateDto();
//		orderCreateDto.setCustomerId(1);
//		orderCreateDto.setDeliveryAddressId(1);
//		
//		OrderDetailCreateDto detail1 =new OrderDetailCreateDto();
//		detail1.setWarehouseDetailId(1);
//		detail1.setQty(2);
//		
//		OrderDetailCreateDto detail2 =new OrderDetailCreateDto();
//		detail2.setWarehouseDetailId(2);
//		detail2.setQty(3);
//		
//		orderCreateDto.setOrderDetails(new ArrayList<OrderDetailCreateDto>(Arrays.asList(detail1,detail2)));
//		
//		System.out.println(orderCreateDto);
////		orderService.createOrder(orderCreateDto);
//	}
	
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
	
	@GetMapping("/orders")
	public ResponseEntity<Object> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/order/{orderId}/order-details")
	public ModelAndView getOrderDetails(@PathVariable("orderId") int orderId){
		return orderService.getOrderDetailsByOrderId(orderId, new ModelAndView());
	}

	
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable("orderId") int orderId){
		return orderService.deleteOrder(orderId);
	}
}
