package com.warehouse.management.address.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

import com.warehouse.management.address.dto.DeliveryAddressDto;
import com.warehouse.management.store.dto.RegionOptionDto;

@Mapper
public interface AddressRepository {
	
	public ArrayList<RegionOptionDto> getRegions();
	
	public DeliveryAddressDto addAddress(DeliveryAddressDto deliveryAddressDto);
	
	public DeliveryAddressDto updateAddress(DeliveryAddressDto deliveryAddressDto);
	
	public void deleteAddress(@Param("addressId") int addressId);

}
