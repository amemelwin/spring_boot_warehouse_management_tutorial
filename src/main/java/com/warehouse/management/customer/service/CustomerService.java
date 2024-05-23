package com.warehouse.management.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ModelAndView getCustomerPage(ModelAndView mav) {
		mav.setViewName("screens/customer/customer");
		
		mav.addObject("customers", customerRepository.getCustomers());
		
		return mav;
	}
	
	public ModelAndView getCustomerAddressPage(int customerId,ModelAndView mav) {
		mav.setViewName("screens/customer/address/address");
		// Add object here for region
		//mav.setViewName("screens/customer/2/address");
		mav.addObject("regionOptions",customerRepository.getRegions());
		mav.addObject("deliveryAddresses",customerRepository.getCustomerDeliveryAddress(customerId));
		return mav;
	}
	
}
