package com.warehouse.management.utility;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ApiResponse {
	
	private int code;
	
	private String status;
	
	private String message;
	
	private Object data;
	
	public ApiResponse(HttpStatus status,String message,Object data) {
		this.code = status.value();
		this.status = status.getReasonPhrase();
		this.message = message;
		this.data = data;
	}
	
	public ApiResponse(HttpStatus status,String message) {
		this(status,message,new HashMap<String, String>());
	}
	
	public ApiResponse(HttpStatus status) {
		this(status,"",new HashMap<String, String>());
	}
	
	public ApiResponse() {
		this(HttpStatus.OK,"",new HashMap<String, String>());
	}
	
	public ResponseEntity<Object> response() {
		return new ResponseEntity<Object>(this,HttpStatus.valueOf(code));
	}
}
