package com.spring.dao;

import java.util.List;

import com.spring.domain.Contactinfo;

public interface ContactinfoMapper {
    int deleteByPrimaryKey(Integer contactid);

    int insert(Contactinfo record);

    int insertSelective(Contactinfo record);

    Contactinfo selectByPrimaryKey(Integer contactid);

    int updateByPrimaryKeySelective(Contactinfo record);

    int updateByPrimaryKey(Contactinfo record);
    
    List<Contactinfo> getAll();
    
    Contactinfo selectByUserid(Integer userid);
}