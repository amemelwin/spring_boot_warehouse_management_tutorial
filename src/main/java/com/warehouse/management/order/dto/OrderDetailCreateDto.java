package com.warehouse.management.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderDetailCreateDto {
	@JsonProperty("order_detail_id")
	private int orderDetailId;

	@JsonProperty("order_id")
	private long orderId;

	@JsonProperty("warehouse_detail_id")
	private int warehouseDetailId;

	@JsonProperty("qty")
	private int qty;

	@JsonProperty("price")
	private long price;

	@JsonProperty("discount")
	private long discount;

	@JsonProperty("product_name")
	private String productName;
	
	// for test
	//private boolean isEnoughStock = false;
	private int stock ;

}
