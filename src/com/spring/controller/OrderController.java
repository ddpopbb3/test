package com.spring.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.Contactinfo;
import com.spring.domain.Goods;
import com.spring.domain.Orders;
import com.spring.domain.User;
import com.spring.service.ContactinfoService;
import com.spring.service.GoodsServive;
import com.spring.service.OrdersService;
import com.spring.service.ProductService;
import com.spring.service.UserService;
import com.spring.serviceimpl.GoodsServiceImpl;

@Controller
public class OrderController {
	@Resource
	private UserService userService;
	
	@Resource
	private ProductService productservice;
	
	@Resource
	private ContactinfoService contactinfoService;
	
	@Resource
	private OrdersService ordersservice;
	
	@RequestMapping(value="/orderConfirm.do")
	public String orderConfirm(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		Contactinfo contactinfo = contactinfoService.selectByUserid(user.getUserid());
		request.setAttribute("cti", contactinfo);
		return "orderConfirm";	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/neworder.do")
	public String newOrder(HttpServletRequest request){
		User user =  (User) request.getSession().getAttribute("user");
		String cost = request.getParameter("cost");
		String pid = request.getParameter("paywayid");
		List<Goods> list = (List<Goods>) request.getSession().getAttribute("goodslist");
		Orders orders = new Orders();
		orders.setUserid(user.getUserid());
		orders.setCost(new BigDecimal(cost));
		orders.setPaywayid(Short.parseShort(pid));
		orders.setStatusid(Short.parseShort("1"));
		System.err.println("request获取成功");
		ordersservice.insertOrders(orders,list);
		request.getSession().setAttribute("goodslist", null);
		List<Orders> list2 = ordersservice.getAll(user.getUserid());
		request.setAttribute("orders", list2);
		return "orderList";	
	}

	
	@RequestMapping(value="/orderdetail.do")
	public String orderDetail(HttpServletRequest request,int orderid){
		if(String.valueOf(orderid)!=null){
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("cti", contactinfoService.selectByUserid(user.getUserid()));
		request.setAttribute("orderdetaillist", ordersservice.getorderDetail(user.getUserid(), orderid));
		return "orderDetail";	}else
			return "login";
	}
	
	@RequestMapping(value="/noShoppingCart.do")
	public String clearShoppingCart(HttpServletRequest request){
		request.setAttribute("list", productservice.getAll());
		request.getSession().setAttribute("goodslist", null);
		return "productList";	
	}
	
	@RequestMapping(value="/goods.do")
	public String getGoods(HttpServletRequest request,String productid,String name,String baseprice){
		if(request.getSession().getAttribute("user")!=null){
		if(productid == null){
			return "shoppingCart";	
		}
		GoodsServive goodsservice =  new GoodsServiceImpl();
		String string = goodsservice.getGoods(request, productid, name,baseprice);
		return string;	}
		return "login";
	}
	
	@RequestMapping(value="/orderlist.do")
	public String getOrderList(HttpServletRequest request){
		if(request.getSession().getAttribute("user")!=null){
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orders",ordersservice.getAll(user.getUserid()));
		return "orderList";	}else {
			return "login";
		}
	}

}
