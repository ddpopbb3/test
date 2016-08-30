package com.spring.serviceimpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.spring.dao.ContactinfoMapper;
import com.spring.dao.UserMapper;
import com.spring.domain.Contactinfo;
import com.spring.domain.User;
import com.spring.service.ContactinfoService;

@Service("ContactService")
public class ContactServiceImpl implements ContactinfoService{

	@Resource
	private ContactinfoMapper contactinfoMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public Contactinfo selectByPrimaryKey(int contactid) {
		Contactinfo contactinfo = new Contactinfo();
		contactinfo=contactinfoMapper.selectByPrimaryKey(contactid);
		return contactinfo;
	}

	@Override
	public List<Contactinfo> getAll() {
		return contactinfoMapper.getAll();
	}

	@Override
	public Contactinfo selectByUserid(Integer userid) {
		return contactinfoMapper.selectByUserid(userid);
	}

	@Override
	public int insert(Contactinfo record) {
		
		return contactinfoMapper.insert(record);
	}
	@Override
	public void RegisterUser(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street1 = request.getParameter("street1");
		String street2 = request.getParameter("street2");
		String zip = request.getParameter("zip");
		String homephone = request.getParameter("homephone");
		String officephone = request.getParameter("officephone");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		userMapper.insert(user);
		Contactinfo contactinfo = new Contactinfo();
		contactinfo.setUserid(userMapper.selectByName(name).getUserid());
		contactinfo.setCountry(country);
		contactinfo.setProvince(province);
		contactinfo.setCity(city);
		contactinfo.setStreet1(street1);
		contactinfo.setStreet2(street2);
		contactinfo.setZip(zip);
		contactinfo.setHomephone(homephone);
		contactinfo.setOfficephone(officephone);
		contactinfo.setCellphone(cellphone);
		contactinfo.setEmail(email);
		contactinfoMapper.insert(contactinfo);
	}
}
