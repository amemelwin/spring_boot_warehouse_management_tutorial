package com.warehouse.management.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.address.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/regions")
	public ModelAndView getOrder(ModelAndView mav) {
		System.out.println("Hello");
		return addressService.getAddressPage(mav);
	}
	
	
	

}
