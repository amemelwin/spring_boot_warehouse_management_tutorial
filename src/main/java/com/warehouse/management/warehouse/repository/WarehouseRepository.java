package com.warehouse.management.warehouse.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.warehouse.management.product.dto.ProductOptionDto;
import com.warehouse.management.store.dto.RegionOptionDto;
import com.warehouse.management.store.dto.WarehouseDto;
import com.warehouse.management.warehouse.detail.dto.WarehouseDetailsDto;

@Mapper

public interface WarehouseRepository {
	public ArrayList<RegionOptionDto> getRegionOption();
	
	public WarehouseDto createAndSelectWarehouse(WarehouseDto warehouseDto);
	
	public ArrayList<WarehouseDto> getWarehouses();
	
	public ArrayList<WarehouseDetailsDto> getWarehouseDetailsByWarehouseId(int warehouseId);
	
	public ArrayList<ProductOptionDto> getProductOption();
	
	public WarehouseDetailsDto createAndSelectWarehouseDetail(WarehouseDetailsDto warehouseDetailDto);
	
	public void deleteWarehouse(int warehouseId);
	
	public void deleteWarehouseDetail(int warehouseDetailId);
	
	

}


