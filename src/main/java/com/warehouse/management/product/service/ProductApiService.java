package com.warehouse.management.product.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.management.product.dto.ProductCreateDto;
import com.warehouse.management.product.dto.ProductDto;
import com.warehouse.management.product.repository.ProductRepository;
import com.warehouse.management.utility.ApiResponse;
import com.warehouse.management.utility.ErrorResponse;

@Service
public class ProductApiService {
	
	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<Object> createProduct(ProductCreateDto productCreateDto){
		
		Map<String,String> errors = productCreateDto.validate();
		
		if(!productRepository.isValidProductCode(productCreateDto.getProductCode())) {
			errors.put("product_code", "有効の商品コードを入力してください。");
		}

		if(errors.size()>0) {
			return new ErrorResponse(HttpStatus.CONFLICT,"商品登録が失敗しました。",errors).response();
		}
		
		ProductDto registeredProduct = productRepository.insertAndSelectProduct(productCreateDto);

		return new ApiResponse(HttpStatus.CREATED,"商品登録が正常に完了しました。",registeredProduct).response();
	}
	
	public ResponseEntity<Object> updateProduct(ProductCreateDto productCreateDto){
		
		Map<String,String> errors = productCreateDto.validate();
		
		if(!productRepository.isValidUpdateProductCode(productCreateDto.getProductCode(),productCreateDto.getProductId())) {
			errors.put("product_code", "有効の商品コードを入力してください。");
		}

		if(errors.size()>0) {
			return new ErrorResponse(HttpStatus.CONFLICT,"商品登録が失敗しました。",errors).response();
		}
		
		ProductDto updatedProduct = productRepository.updateAndSelectProduct(productCreateDto);
		
		return new ApiResponse(HttpStatus.OK,"商品変更することが正常に完了しました。",updatedProduct).response();
	}
	
	public ResponseEntity<Object> deleteProduct(long productId){
		try {
			productRepository.deleteProduct(productId);
			return new ApiResponse(HttpStatus.NO_CONTENT,"OK").response();
		}catch(Exception e) {
			return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"NG").response();
		}
	}
}
