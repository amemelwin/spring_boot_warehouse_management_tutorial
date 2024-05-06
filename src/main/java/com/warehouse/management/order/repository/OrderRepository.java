package com.warehouse.management.order.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.warehouse.management.order.dto.OptionDto;

@Mapper
public interface OrderRepository {

	public ArrayList<OptionDto> getCustomerOption();
	
	public ArrayList<OptionDto> getDeliveryAddressOption(@Param("customerId") int customerId);
	
	public ArrayList<OptionDto> getWarehouseProductOption(@Param("addressId") int addressId);
}
