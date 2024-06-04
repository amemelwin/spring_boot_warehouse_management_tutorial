package com.warehouse.management.store.controller;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.store.dto.WarehouseDto;
import com.warehouse.management.store.service.WarehouseService;
import com.warehouse.management.warehouse.detail.dto.WarehouseDetailsDto;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1")
public class ApiWarehouseController {
	
//	@PostConstruct
//	public void init() {
//		validate(new WarehouseDto());
//	}
//	
	@Autowired
	private WarehouseService warehouseService;
	
	@PostMapping("/warehouse")
	public ResponseEntity<Object> addWarehouse(@RequestBody WarehouseDto warehouseDto){
		return warehouseService.addWarehouse(warehouseDto);
	}
	
	@DeleteMapping("/warehouse/{warehouseId}")
    public ResponseEntity<Object> deleteWarehouse(@PathVariable("warehouseId") int warehouseId){
    	return warehouseService.deleteWarehouse(warehouseId);
    }
	
    @PostMapping("/warehouse/{warehouseId}/warehouse-detail")
	public ResponseEntity<Object> addWarehouseDetail(@PathVariable("warehouseId") int warehouseId,@RequestBody WarehouseDetailsDto warehouseDetailDto){
    	warehouseDetailDto.setWarehouseId(warehouseId);
		return warehouseService.addWarehouseDetail(warehouseDetailDto);
	}
    
    @DeleteMapping("/warehouse-details/{warehouseDetailId}")
    public ResponseEntity<Object> deleteWarehouseDetail(@PathVariable("warehouseDetailId") int warehouseDetailId){
    	return warehouseService.deleteWarehouseDetail(warehouseDetailId);
    }
    
	
	private void validate(Object obj) {
		Class<?> cls = obj.getClass();

		// Get all the declared fields of the class
		Field[] fields = cls.getDeclaredFields();

		// Loop through each field and print its name and value
		for (Field field : fields) {
			// Ensure accessibility for private fields
			field.setAccessible(true);

			// Get the name of the field
			String fieldName = field.getName();

			// Get the value of the field for the current object
			try {
				Object value = field.get(obj);
				Class<?> fieldType = field.getType();

				System.out.println(fieldName + ": " + value + " (Type: " + fieldType.getSimpleName() + ")");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}


}
