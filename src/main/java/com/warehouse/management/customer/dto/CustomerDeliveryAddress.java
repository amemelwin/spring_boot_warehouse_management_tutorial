package com.warehouse.management.customer.dto;

import lombok.Data;

@Data
public class CustomerDeliveryAddress {
	
	private int deliveryAddressId;
	
	private long regionId;
	
	private String regionName;
	
	private String addressName;

	private String address;
	
	private String postCode;
	
	private int main;
}
