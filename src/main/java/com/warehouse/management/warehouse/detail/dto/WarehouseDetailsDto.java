package com.warehouse.management.warehouse.detail.dto;

import lombok.Data;

@Data
public class WarehouseDetailsDto {
	
	private int warehouse_detail_id;
	private int warehouse_id;
	private int product_id;
	private String product_name;
	private int stock;

}
