package com.warehouse.management.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int code;
	
	private String status;
	
	private String message;
	
	private Map<String,String> errors;
	
	public ErrorResponse(HttpStatus status,String message,Map<String,String> errors) {
		this.code = status.value();
		this.status = status.getReasonPhrase();
		this.message = message;
		this.errors = errors;
	}
	
	public ErrorResponse(HttpStatus status,String message) {
		this.code = status.value();
		this.status = status.getReasonPhrase();
		this.message = message;
		this.errors = new HashMap<String, String>();
	}
	
	public ErrorResponse(String message) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		this.code = status.value();
		this.status = status.getReasonPhrase();
		this.message = message;
		this.errors = new HashMap<String, String>();
	}
	
	public ErrorResponse() {
		this("NG");
	}
	
	public ResponseEntity<Object> response() {
		return new ResponseEntity<Object>(this,HttpStatus.valueOf(code));
	}
}
