package com.warehouse.management.customer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.management.customer.dto.CustomerCreateDto;
import com.warehouse.management.customer.dto.CustomerDto;
import com.warehouse.management.customer.repository.CustomerRepository;
import com.warehouse.management.utility.ApiResponse;
import com.warehouse.management.utility.ErrorResponse;

@Service
public class CustomerApiService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseEntity<Object> createCustomer(CustomerCreateDto customerCreateDto){
		Map<String,String> errors = customerCreateDto.validate();
		if(errors.size()>0) {
			return new ErrorResponse(HttpStatus.CONFLICT,"顧客様登録が失敗しました。",errors).response();
		}
		
		CustomerDto customerDto = customerRepository.insertAndSelectCustomer(customerCreateDto);
		return new ApiResponse(HttpStatus.OK,"顧客様登録が成功しました。",customerDto).response();
	}

}
