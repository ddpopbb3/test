package com.spring.service;

import java.util.List;

import com.spring.domain.Product;

public interface ProductService {
	public Product selectByPrimaryKey(Long productid);
	public List<Product> getAll();
	
}
