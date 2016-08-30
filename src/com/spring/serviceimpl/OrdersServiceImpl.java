package com.spring.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.OrderDetailMapper;
import com.spring.dao.OrderlineMapper;
import com.spring.dao.OrdersMapper;
import com.spring.domain.Goods;
import com.spring.domain.OrderDetail;
import com.spring.domain.Orderline;
import com.spring.domain.Orders;
import com.spring.service.OrdersService;

@Service("OrdersService")
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper ordersmapper;
	
	@Resource
	private OrderlineMapper orderlinemapper;
	
	@Resource
	private OrderDetailMapper orderdetailmapper;

	@Override
	public int insertOrders(Orders orders, List<Goods> list) {
		ordersmapper.insert(orders);
		for (int i = 0; i < list.size(); i++) {
			Goods goods = list.get(i);
			int amount = goods.getAmount();
			String pid = goods.getProductid();
			Orderline orderline = new Orderline();
			orderline.setAmount(new BigDecimal(String.valueOf(amount)));
			orderline.setProductid(Long.parseLong(pid));
			orderline.setOrderid(ordersmapper.count(orders.getUserid()));
			orderlinemapper.insert(orderline);
		}
		System.out.println("大成功！");
		return 1;
	}

	@Override
	public int count(int userid) {
		return ordersmapper.count(userid);
	}

	@Override
	public List<Orders> getAll(int userid) {
		return ordersmapper.getAll(userid);
	}

	@Override
	public List<OrderDetail> getorderDetail(int userid, int orderid) {
		System.out.println("---msg---");
		return orderdetailmapper.getorderDetail(userid, orderid);
	}
}
