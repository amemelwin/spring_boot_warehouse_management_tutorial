package com.warehouse.management.order.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.warehouse.management.order.dto.OptionDto;
import com.warehouse.management.order.dto.OrderCreateDto;
import com.warehouse.management.order.dto.OrderCreateResponseDto;
import com.warehouse.management.order.dto.OrderDetailDto;

@Mapper
public interface OrderRepository {

	public ArrayList<OptionDto> getCustomerOption();
	
	public ArrayList<OptionDto> getDeliveryAddressOption(@Param("customerId") int customerId);
	
	public ArrayList<OrderDetailDto> getWarehouseProductOption(@Param("addressId") int addressId);
	
	public OrderCreateResponseDto createAndSelectOrder(OrderCreateDto orderCreateDto);
}
