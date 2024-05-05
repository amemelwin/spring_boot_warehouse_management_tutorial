package com.warehouse.management.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.product.dto.ProductDto;
import com.warehouse.management.product.dto.ProductForm;
import com.warehouse.management.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ModelAndView getProductService(ModelAndView mav) {
		
		mav.setViewName("screens/product/product");
		
		ArrayList<ProductDto> products = productRepository.getAllProducts();
		
		mav.addObject("products",products);
		mav.addObject("categoryOptions",productRepository.getCategoryOptions());
		return mav;
	}
	
	public ModelAndView createProductPage(ModelAndView mav) {
		mav.setViewName("screens/product/create-product");
		
		ProductForm form = new ProductForm();
		
		mav.addObject("productForm",form);
		mav.addObject("categoryOptions",productRepository.getCategoryOptions());
		
		return mav;
	}
	
	public ModelAndView createProduct(ProductForm productForm,BindingResult result, ModelAndView mav) {
		mav.addObject("categoryOptions",productRepository.getCategoryOptions());
		
		if(!productRepository.isValidProductCode(productForm.getProductCode())) {
			result.addError(new FieldError("productForm", "productCode", productForm.getProductCode()+" is already existed!"));
		}
		
		if(result.hasErrors()) {	
			mav.setViewName("screens/product/create-product");
			return mav;
		}
		
		productRepository.createProduct(productForm);
		mav.setViewName("redirect:/product");
		return mav;
	}
}
