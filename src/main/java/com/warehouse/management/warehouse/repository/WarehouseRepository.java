package com.warehouse.management.warehouse.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.warehouse.management.store.dto.RegionOptionDto;
import com.warehouse.management.store.dto.WarehouseDto;

@Mapper

public interface WarehouseRepository {
	public ArrayList<RegionOptionDto> getRegionOption();
	
	public WarehouseDto createAndSelectWarehouse(WarehouseDto warehouseDto);

}


