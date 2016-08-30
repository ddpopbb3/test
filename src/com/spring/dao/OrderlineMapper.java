package com.spring.dao;

import com.spring.domain.Orderline;

public interface OrderlineMapper {
    int deleteByPrimaryKey(Integer lineid);

    int insert(Orderline record);

    int insertSelective(Orderline record);

    Orderline selectByPrimaryKey(Integer lineid);

    int updateByPrimaryKeySelective(Orderline record);

    int updateByPrimaryKey(Orderline record);
}