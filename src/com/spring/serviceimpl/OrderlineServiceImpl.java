package com.spring.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.OrderlineMapper;
import com.spring.domain.Orderline;
import com.spring.service.OrderlineService;

@Service("OrderlineService")
public class OrderlineServiceImpl implements OrderlineService {

	@Resource
	private OrderlineMapper orderlinemapper;
	
	@Override
	public Orderline selectByPrimaryKey(Integer lineid) {
		return orderlinemapper.selectByPrimaryKey(lineid);
	}

	@Override
	public int insert(Orderline record) {
		return orderlinemapper.insert(record);
	}

}
