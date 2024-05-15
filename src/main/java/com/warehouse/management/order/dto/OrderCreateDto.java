package com.warehouse.management.order.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderCreateDto {
	
	@JsonProperty("order_details")
    private ArrayList<OrderDetailsDto> orderDetails;
	
	
	@JsonProperty("customer_id")
	private int customerId;
	
	public class OrderDetailsDto {

	    @JsonProperty("qty")
	    private int qty;

	    @JsonProperty("warehouse_detail_id")
	    private int warehouseDetailId;
	}
}
//order_details