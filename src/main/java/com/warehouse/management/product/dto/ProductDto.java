package com.warehouse.management.product.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductDto {
	
	private int productId;
	
	private int categoryId;
	
	private String categoryName;
	
	private String productName;
	
	private String productCode;
	
	private int price;
	
	private int discount;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
}
