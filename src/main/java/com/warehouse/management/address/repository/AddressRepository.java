package com.warehouse.management.address.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.warehouse.management.address.dto.DeliveryAddressDto;
import com.warehouse.management.address.dto.RegionOptionDto;

@Mapper
public interface AddressRepository {
	
	public ArrayList<RegionOptionDto> getRegions();
	
	public DeliveryAddressDto addAddress(DeliveryAddressDto deliveryAddressDto);

}
