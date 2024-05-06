package com.warehouse.management.customer.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.warehouse.management.customer.dto.CustomerDeliveryAddress;
import com.warehouse.management.customer.dto.CustomerDto;

@Mapper
public interface CustomerRepository {

	public ArrayList<CustomerDto> getCustomers();
	
	public ArrayList<CustomerDeliveryAddress> getCustomerDeliveryAddress(@Param("customerId") int customerId);
}
