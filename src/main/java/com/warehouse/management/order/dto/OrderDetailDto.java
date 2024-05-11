package com.warehouse.management.order.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

	private int warehouseDetailId;
	private String productName;
	private long price;
	private int discount;
}
