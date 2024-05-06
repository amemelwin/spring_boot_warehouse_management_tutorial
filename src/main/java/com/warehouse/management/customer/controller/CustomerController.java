package com.warehouse.management.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public ModelAndView getCustomerPage(ModelAndView mav) {
		
		return customerService.getCustomerPage(mav);
	}
	
	/* Customer's Address */
	@GetMapping("/{customerId}/address")
	public ModelAndView getCustomerAddressPage(ModelAndView mav,@PathVariable int customerId) {

		return customerService.getCustomerAddressPage(customerId,mav);
	}
}
