package com.warehouse.management.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.store.service.WarehouseService;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {
	
	@Autowired
	WarehouseService warehouseService;
	
	@GetMapping("")
	public ModelAndView getWarehousePage(ModelAndView mav) {
		
		return warehouseService.getWarehousePage(mav);
	}
	
	@GetMapping("/{warehouseId}/warehouseDetails")
	public ModelAndView getWarehouseDetailsByWarehouseId(ModelAndView mav, @PathVariable("warehouseId") int warehouseId){
		return warehouseService.getWarehouseDetailsByWarehouseId(mav,warehouseId);
	}

}
