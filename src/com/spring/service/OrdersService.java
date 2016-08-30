package com.spring.service;

import java.util.List;

import com.spring.domain.Goods;
import com.spring.domain.OrderDetail;
import com.spring.domain.Orders;

public interface OrdersService {
	int insertOrders(Orders orders,List<Goods> list);
	
	int count(int userid);
	
	List<Orders> getAll(int userid);
	
	List<OrderDetail> getorderDetail(int userid,int orderid);
}
