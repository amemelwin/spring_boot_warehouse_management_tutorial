package com.warehouse.management.customer.dto;

import lombok.Data;

@Data
public class CustomerDto {

	private int customerId;
	private String firstName;
	private String lastName;
	private String mail;
	private String phone;
	private int point;
	private int numOfAddress;
}
