package com.warehouse.management.customer.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.warehouse.management.customer.dto.CustomerCreateDto;
import com.warehouse.management.customer.dto.CustomerDeliveryAddress;
import com.warehouse.management.customer.dto.CustomerDto;

@Mapper
public interface CustomerRepository {

	public ArrayList<CustomerDto> getCustomers();
	
	public ArrayList<CustomerDeliveryAddress> getCustomerDeliveryAddress(@Param("customerId") int customerId);
	
	public CustomerDto insertAndSelectCustomer(CustomerCreateDto customerCreateDto);
	
	public boolean isValidMail(String mail, long customerId);
	
	public CustomerDto updateAndSelectCustomer(CustomerCreateDto customerCreateDto,long customerId);
	
	public void deleteCustomer(long customerId);
}
