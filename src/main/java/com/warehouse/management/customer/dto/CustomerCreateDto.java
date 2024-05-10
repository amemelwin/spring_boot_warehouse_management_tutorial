package com.warehouse.management.customer.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.warehouse.management.utility.CommonUtility;

import lombok.Data;

@Data
public class CustomerCreateDto {

	@JsonProperty("customer_id")
	private long customerId;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("mail")
	private String mail;

	@JsonProperty("phone")
	private String phone;

	public Map<String, String> validate() {
		Map<String, String> errors = new HashMap<String, String>();

		if (firstName == null) {
			errors.put("first_name", "名を記入してください。");
		}
//		else if(firstName !=null && firstName.equals("")) {
//			errors.put("first_name", "名を記入してください。");
//		}

		if (lastName == null) {
			errors.put("last_name", "姓を記入してください。");
		}

		if (mail == null) {
			errors.put("mail", "メールにご記入ください");
		} else {
			if (!CommonUtility.isValidEmail(mail)) {
				errors.put("mail", "有効な電子メール形式を入力してください");
			}
		}

		if (phone == null) {
			errors.put("phone", "電話番号を記入してください");
		} else {
			if (!CommonUtility.isValidMyanmarPhoneNumber(phone)) {
				errors.put("phone", "有効な電話番号の形式を入力してください");
			}
		}

		return errors;
	}

}
