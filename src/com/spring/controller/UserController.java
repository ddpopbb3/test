package com.spring.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.LoginCommand;
import com.spring.domain.Product;
import com.spring.domain.User;
import com.spring.service.ContactinfoService;
import com.spring.service.OrdersService;
import com.spring.service.ProductService;
import com.spring.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private ProductService productservice;
	
	@Resource
	private ContactinfoService contactinfoService;
	
	@Resource
	private OrdersService ordersservice;
	
	
	@RequestMapping(value="/index.html")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/tologin.do")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		request.getSession().setAttribute("user", null);
		boolean isValidUser = userService.hasMatchUser(loginCommand);
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或者密码错误");
		} else {
			User user = new User();
			user.setName(loginCommand.getName());
			user = userService.selectByName(loginCommand.getName());
			request.getSession().setAttribute("user", user);
			ArrayList<Product> list = new ArrayList<Product>();
			list = (ArrayList<Product>) productservice.getAll();
			request.setAttribute("list", list);
			return new ModelAndView("productList");
		}
	}
		
	@RequestMapping(value="/userRegister.do")
	public String userRegister(HttpServletRequest request){
		return "userRegister";	
	}
	
	@RequestMapping(value="/douserRegister.do")
	public ModelAndView douserRegister(HttpServletRequest request,User user){
		if(userService.isExistUser(user.getName()))
			return new ModelAndView("userRegister","error", "用户名已存在");
		else if(user.getPassword()=="")
			return new ModelAndView("userRegister","error2", "密码不能为空");
		else if(user.getName()=="")
			return new ModelAndView("userRegister","error", "用户名不能为空");
		else if(!request.getParameter("password2").equals(user.getPassword()))
			return new ModelAndView("userRegister","error3", "两次输入的密码不一致");
		else
			contactinfoService.RegisterUser(request);	
		return new ModelAndView("login");
			
	
	}
	
	@RequestMapping(value="/userList.do")
	public String userList(HttpServletRequest request){
		request.setAttribute("userlist", userService.getAll());
		return "userManage";	
	}
	
	@RequestMapping(value="/userModify.do")
	public String userModify(HttpServletRequest request,int userid){
		request.setAttribute("user", userService.selectByPrimaryKey(userid));
		System.out.println(userService.selectByPrimaryKey(userid));
		request.setAttribute("contactinfo", contactinfoService.selectByUserid(userid));
		return "userModify";	
	}
	
	@RequestMapping(value="/userUpdate.do")
	public String userUpdate(HttpServletRequest request){
		
		return "userManage";	
	}
	

	
}
