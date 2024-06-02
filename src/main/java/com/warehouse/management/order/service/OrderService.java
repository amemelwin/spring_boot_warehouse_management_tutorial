package com.warehouse.management.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.order.dto.OrderCreateDto;
import com.warehouse.management.order.dto.OrderDetailCreateDto;
import com.warehouse.management.order.repository.OrderRepository;
import com.warehouse.management.utility.ApiResponse;
import com.warehouse.management.utility.ErrorResponse;

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
	
	//@Transactional
	public ResponseEntity<Object> createOrder(OrderCreateDto orderCreateDto){
		try {
		    Map<String,String> errors = new HashMap<String,String>();
		    for(OrderDetailCreateDto detail:orderCreateDto.getOrderDetails()) {
		        OrderDetailCreateDto result =  orderRepository.checkIsEnoughStock(detail);                
		        // Check if there is enough stock
		        if(result.getStock() < detail.getQty() ) {
		            errors.put(String.valueOf(detail.getWarehouseDetailId()), result.getProductName() + "は　残在庫" + result.getStock() + "個しかありません。");
		        }                   
		    }
		    if(errors.size() > 0) {
		        // If there are errors, return them
		        return new ErrorResponse(HttpStatus.CONFLICT, "Order failed", errors).response();
		    } else {
		        // If there are no errors, proceed with creating the order
		        OrderCreateDto orderCreateDtoRes = orderRepository.createAndSelectOrder(orderCreateDto);
		        orderCreateDtoRes.setOrderDetails(orderRepository.selectOrderDetails(orderCreateDtoRes.getOrderId()));
		        return new ApiResponse(HttpStatus.OK, "Success", orderCreateDtoRes).response();
		    }
		} catch (Exception e) {
		    // Handle exception and rollback transaction
		    e.printStackTrace();
		    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred.").response();
		}

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
