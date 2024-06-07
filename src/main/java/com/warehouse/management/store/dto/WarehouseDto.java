package com.warehouse.management.store.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WarehouseDto {
	
	@JsonProperty("warhouse_id")
	private int warehouseId;
	
	@JsonProperty("region_id")
	private int regionId;
	
	@JsonProperty("warehouse_name")
	private String warehouseName;
	
	@JsonProperty("no_of_warehouse_detail")
	private int noOfwarehouseDetail;
	
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
