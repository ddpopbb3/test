package com.spring.service;

import com.spring.domain.Orderline;

public interface OrderlineService {
	Orderline selectByPrimaryKey(Integer lineid);
	
	int insert(Orderline record);
}
