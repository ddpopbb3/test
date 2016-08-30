package com.spring.service;

import javax.servlet.http.HttpServletRequest;

public interface GoodsServive {
	public String getGoods(HttpServletRequest request,String productid,String name,String baesprice);
	
}
