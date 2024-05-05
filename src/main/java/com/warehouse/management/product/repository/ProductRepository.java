package com.warehouse.management.product.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.warehouse.management.product.dto.CategoryOption;
import com.warehouse.management.product.dto.ProductCreateDto;
import com.warehouse.management.product.dto.ProductDto;
import com.warehouse.management.product.dto.ProductForm;

@Mapper
public interface ProductRepository {
	
	public ArrayList<ProductDto> getAllProducts();
	
	public ArrayList<CategoryOption> getCategoryOptions();
	
	public void createProduct(ProductForm productForm);
	
	public boolean isValidProductCode(@Param("productCode") String productCode);
	
	public ProductDto insertAndSelectProduct(ProductCreateDto productCreateDto);
}
