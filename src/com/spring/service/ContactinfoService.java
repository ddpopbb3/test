package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.domain.Contactinfo;

public interface ContactinfoService {
	public Contactinfo selectByPrimaryKey(int contactid);
	public List<Contactinfo> getAll();
	public Contactinfo selectByUserid(Integer userid);
	int insert(Contactinfo record);
	public void RegisterUser(HttpServletRequest request);
}
