package com.spring.dao;

import java.util.List;

import com.spring.domain.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Long productid);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Long productid);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> getAll();
}