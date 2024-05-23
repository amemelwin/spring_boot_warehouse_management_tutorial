package com.warehouse.management.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.address.AddressService;
import com.warehouse.management.address.dto.DeliveryAddressDto;

@RestController
@RequestMapping("/customer/{customerId}/api/v1")
public class ApiAddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/delivery-address")
	public ResponseEntity<Object> addNewAddress(@RequestBody DeliveryAddressDto deliveryAddressDto,@PathVariable("customerId") int customerId){
		deliveryAddressDto.setCustomerId(customerId);
		return addressService.addNewAddress(deliveryAddressDto);
	}

}
