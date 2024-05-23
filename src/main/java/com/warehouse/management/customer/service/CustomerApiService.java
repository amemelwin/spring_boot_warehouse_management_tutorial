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

	public ResponseEntity<Object> createCustomer(CustomerCreateDto customerCreateDto) {
		Map<String, String> errors = customerCreateDto.validate();
		if (errors.size() > 0) {
			return new ErrorResponse(HttpStatus.CONFLICT, "顧客様登録が失敗しました。", errors).response();
		}

		CustomerDto customerDto = customerRepository.insertAndSelectCustomer(customerCreateDto);
		return new ApiResponse(HttpStatus.CREATED, "顧客様登録が成功しました。", customerDto).response();
	}

	public ResponseEntity<Object> updateCustomer(CustomerCreateDto customerCreateDto) {
		try {
			Map<String, String> errors = customerCreateDto.validate();
			if (!customerRepository.isValidMail(customerCreateDto.getMail(), customerCreateDto.getCustomerId())) {
				errors.put("mail", "メールアドレスは無効です。");
			}

			if (errors.size() > 0) {
				return new ErrorResponse(HttpStatus.CONFLICT, "顧客様更新が失敗しました。", errors).response();
			}

			CustomerDto customerDto = customerRepository.updateAndSelectCustomer(customerCreateDto);

			return new ApiResponse(HttpStatus.OK, "顧客様更新が成功しました。", customerDto).response();
		} catch (Exception e) {
			return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "サーバーエラーが発生しました。").response();
		}

	}
	
	public ResponseEntity<Object> deleteCustomer(long customerId){
		try {
			customerRepository.deleteCustomer(customerId);
			return new ApiResponse(HttpStatus.NO_CONTENT, "顧客削除が成功しました。").response();

		}catch (Exception e) {
			return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "サーバーエラーが発生しました。").response();
		}
	}

}
