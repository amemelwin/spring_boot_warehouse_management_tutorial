package com.warehouse.management.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warehouse.management.product.dto.ProductForm;
import com.warehouse.management.product.service.ProductService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostConstruct
	public void init() {
//		System.out.println(CommonUtility.parseInt("123s"));
	}

	@GetMapping("")
	public ModelAndView getProducts(ModelAndView mav) {
		return productService.getProductService(mav);
	}
	
	@GetMapping("/create")
	public ModelAndView createProduct(ModelAndView mav) {
		
		return productService.createProductPage(mav);
	}
	
	@PostMapping("/create")
	public ModelAndView createProduct(@Valid ProductForm productForm,BindingResult result,ModelAndView mav) {
		return productService.createProduct(productForm,result, mav);
	}
}

