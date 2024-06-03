package com.warehouse.management.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.store.dto.WarehouseDto;
import com.warehouse.management.utility.ApiResponse;
import com.warehouse.management.warehouse.repository.WarehouseRepository;

@Service
public class WarehouseService {
	
	@Autowired
	WarehouseRepository warehouseRepository;

	public ModelAndView getWarehousePage(ModelAndView mav) {
		mav.setViewName("screens/warehouse/warehouse");		
		mav.addObject("regionOptions",warehouseRepository.getRegionOption());
		mav.addObject("warehouses",warehouseRepository.getWarehouses());
		return mav;
	}
	
	public ResponseEntity<Object> addWarehouse(WarehouseDto warhouseDto){
		warehouseRepository.createAndSelectWarehouse(warhouseDto);
		return new ApiResponse(HttpStatus.CREATED, "success").response();
	}
	
	public ModelAndView getWarehouseDetailsByWarehouseId(ModelAndView mav,int warehouseId){
		mav.setViewName("screens/warehouse/warehouseDetail");
		mav.addObject("warehouseDetails",warehouseRepository.getWarehouseDetailsByWarehouseId(warehouseId));
		return mav;
		//return new ApiResponse(HttpStatus.OK, "success",warehouseRepository.getWarehouseDetailsByWarehouseId(warehouseId)).response();

	}
}
