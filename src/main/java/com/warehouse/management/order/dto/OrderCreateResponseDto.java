package com.warehouse.management.order.dto;

import lombok.Data;

@Data
public class OrderCreateResponseDto {
	private int orderDetailid; // auto
	private int warehouseDetailId;// known
	private int orderId;
	private int qty;// known
	private int price;
	private int discount;	
	private String productName;

}
