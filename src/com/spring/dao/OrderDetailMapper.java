package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.OrderDetail;

public interface OrderDetailMapper {
	List<OrderDetail> getorderDetail(@Param("userid")int userid,@Param("orderid")int orderid);
}
