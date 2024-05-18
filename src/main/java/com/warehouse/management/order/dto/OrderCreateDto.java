package com.warehouse.management.order.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderCreateDto {
	
	@JsonProperty("order_id")
	private int orderId;
	
	@JsonProperty("employee_id")
	private int employeeId;
	
	@JsonProperty("order_details")
    private ArrayList<OrderDetailCreateDto> orderDetails;	
	
	@JsonProperty("customer_id")
	private int customerId;
	
	@JsonProperty("delivery_address_id")
	private int deliveryAddressId;
	
	@JsonProperty("order_code")
	private String orderCode;
	
	@JsonProperty("status")
	private int status;
	
	
}
