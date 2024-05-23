package com.warehouse.management.order.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.order.dto.OrderCreateDto;
import com.warehouse.management.order.dto.OrderDetailCreateDto;
import com.warehouse.management.order.repository.OrderRepository;
import com.warehouse.management.utility.ApiResponse;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;	
	
	public ModelAndView getOrderPage(ModelAndView mav) {
		mav.setViewName("screens/order/order");	
		mav.addObject("customerOptions",orderRepository.getCustomerOption());
		mav.addObject("orders",orderRepository.getOrders());
		
		return mav;
	}
	
	public ResponseEntity<Object> getCustomerDeliveryAddress(int customerId){
		return new ApiResponse(HttpStatus.OK,"OK",orderRepository.getDeliveryAddressOption(customerId)).response();
	}
	
	public ResponseEntity<Object> getWarehouseProductOption(int addressId){
		return new ApiResponse(HttpStatus.OK,"OK",orderRepository.getWarehouseProductOption(addressId)).response();
	}
	
	public ResponseEntity<Object> createOrder(OrderCreateDto orderCreateDto){
		OrderCreateDto orderCreateDtoRes = orderRepository.createAndSelectOrder(orderCreateDto);
		orderCreateDtoRes.setOrderDetails( orderRepository.selectOrderDetails(orderCreateDtoRes.getOrderId()) );
		// orderCreateDtoRes.setOrderDetails(orderCreateDto.getOrderDetails());
		//System.out.println(orderCreateDtoRes.getOrderDetails());
		//ArrayList<OrderDetailCreateDto> orderDetailCreateDtoRes= orderRepository.createAndSelectOrderDetails(orderCreateDto.getOrderDetails(),orderCreateDto.getCustomerId());
		return new ApiResponse(HttpStatus.OK,"Succc",orderCreateDtoRes).response();
	}
	
	public ResponseEntity<Object> getOrders(){
		return new ApiResponse(HttpStatus.OK,"Ok",orderRepository.getOrders()).response();
	}
	
	public ResponseEntity<Object> deleteOrder(int orderId){
		orderRepository.deleteOrder(orderId);
		return new ApiResponse(HttpStatus.OK,"Delete Successfully").response();
	}
	
	public ModelAndView getOrderDetailsByOrderId(int orderId,ModelAndView mav){
		ArrayList<OrderDetailCreateDto> orderDetails = orderRepository.selectOrderDetails(orderId);
		mav.setViewName("screens/order/order");
		mav.addObject("orderDetails",orderDetails);
		return mav;

	}
}
