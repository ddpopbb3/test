package com.spring.serviceimpl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.spring.dao.ProductMapper;
import com.spring.domain.Product;
import com.spring.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productmapper;
	
	@Override
	public Product selectByPrimaryKey(Long productid) {
		Product product = new Product();
		product=productmapper.selectByPrimaryKey(productid);
		return product;
	}

	@Override
	public List<Product> getAll() {
		return productmapper.getAll();
	}

	
}
