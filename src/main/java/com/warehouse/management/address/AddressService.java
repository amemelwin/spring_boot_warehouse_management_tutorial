package com.warehouse.management.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.management.address.dto.DeliveryAddressDto;
import com.warehouse.management.address.repository.AddressRepository;
import com.warehouse.management.utility.ApiResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public ResponseEntity<Object> addNewAddress(DeliveryAddressDto deliveryAddressDto){
		return new ApiResponse(HttpStatus.CREATED,"successfully created",addressRepository.addAddress(deliveryAddressDto)).response();
	}

	public ResponseEntity<Object> updateAddress(DeliveryAddressDto deliveryAddressDto){
		return new ApiResponse(HttpStatus.OK,"successfully updated",addressRepository.updateAddress(deliveryAddressDto)).response();
	}
	
	public ResponseEntity<Object> deleteAddress(int addressId){
		addressRepository.deleteAddress(addressId);
		return new ApiResponse(HttpStatus.NO_CONTENT,"Successfully deleted").response();
	}
}
