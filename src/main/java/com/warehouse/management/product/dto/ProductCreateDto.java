package com.warehouse.management.product.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.warehouse.management.utility.CommonUtility;

import lombok.Data;

@Data
public class ProductCreateDto {
	
	@JsonProperty("product_id")
	private long productId;

	@JsonProperty("category_id")
	private long categoryId;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("product_code")
	private String productCode;
	
	@JsonProperty("price")
	private String price;
	
	@JsonProperty("discount")
	private String discount;
	
	public Map<String,String> validate(){
		Map<String,String> errors = new HashMap<String, String>();
		
		if(categoryId<1) {
			errors.put("category_id","カテゴリーIDを入力してください。");
		}
		// 1.1 p.name.length > 4
		if(productName == null) {
			errors.put("product_name","商品名を入力してください。");
		}else if(productName.length()<5) {
			errors.put("product_name","製品名を長さ4以上で入力してください");
		}
		// 1.2 p.code.length > 6
		if(productCode == null) {
			errors.put("product_code","商品コードを入力してください。");
		}else if(productCode.length()<7) {
			errors.put("product_code","商品コードを長さ6以上で入力してください");
		}
		// 1.3 p.price > 0
		if(!(CommonUtility.parseLong(price)>0)) {
			errors.put("price","価格を１以上で入力してください。");
		}
		// 1.4 p.discount < 100
		if(!(CommonUtility.parseInt(discount)>-1)) {
			errors.put("discount","割引を１以上で入力してください。");
		}else if(CommonUtility.parseInt(discount)>99) {
			errors.put("discount","割引を９９以下で入力してください。");
		}
		
		return errors;
	}
}
