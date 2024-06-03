package com.warehouse.management.warehouse.detail.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WarehouseDetailsDto {
	
	@JsonProperty("warehouse_detail_id")
	private int warehouseDetailId;
	
	@JsonProperty("warehouse_id")
	private int warehouseId;
	
	@JsonProperty("product_id")
	private int productId;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("stock")
	private int stock;
	
	@JsonProperty("safe_stock_amt")
	private int safeStockAmount;
	
	@JsonProperty("lead_days")
	private int leadDays;
	
	@JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Timestamp updatedAt;
    
    @JsonProperty("deleted_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Timestamp deletedAt;

}
