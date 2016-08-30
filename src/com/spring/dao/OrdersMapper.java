package com.spring.dao;

import java.util.List;

import com.spring.domain.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    int count (Integer userid);

	List<Orders> getAll(int userid);
}