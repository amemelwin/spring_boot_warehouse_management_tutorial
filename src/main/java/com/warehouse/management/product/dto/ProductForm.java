package com.warehouse.management.product.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private long categoryId;
	
	@NotBlank(message = "商品名を入力してください。")
	private String productName;
	
	@NotBlank(message= "商品コードを入力してください。")
	private String productCode;
	
	@NotNull()
	@Min(value = 1,message = "価格を入力してください。")
	private long price;
	
	@NotNull()
	@Min(value = 0,message = "割引を入力してください。")
	@Max(value = 20,message = "割引を２０以下に設定してください。")
	private int discount;
	
}
