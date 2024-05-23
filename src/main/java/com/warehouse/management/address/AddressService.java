package com.warehouse.management.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.address.dto.DeliveryAddressDto;
import com.warehouse.management.address.repository.AddressRepository;
import com.warehouse.management.utility.ApiResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public ModelAndView getAddressPage(ModelAndView mav) {
		mav.setViewName("redirect:/customer/2/address");
		mav.addObject("regionOptions");
		return mav;
	}
	
	public ResponseEntity<Object> addNewAddress(DeliveryAddressDto deliveryAddressDto){
		return new ApiResponse(HttpStatus.OK,"successfully created",addressRepository.addAddress(deliveryAddressDto)).response();
	}

}
