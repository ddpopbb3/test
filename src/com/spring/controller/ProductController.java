package com.spring.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.LoginCommand;
import com.spring.domain.Product;
import com.spring.service.ContactinfoService;
import com.spring.service.OrdersService;
import com.spring.service.ProductService;
import com.spring.service.UserService;

@Controller
public class ProductController {
	@Resource
	private UserService userService;
	
	@Resource
	private ProductService productservice;
	
	@Resource
	private ContactinfoService contactinfoService;
	
	@Resource
	private OrdersService ordersservice;

	@RequestMapping(value="/productDetail.do")
	public ModelAndView productDetail(HttpServletRequest request, LoginCommand loginCommand){
		return new ModelAndView("productDetail");	
	}
	
	@RequestMapping(value="/productList.do")
	public String productList(HttpServletRequest request){
		ArrayList<Product> list = new ArrayList<Product>();
		list = (ArrayList<Product>) productservice.getAll();
		request.setAttribute("list", list);
		return "productList";	
	}

}
