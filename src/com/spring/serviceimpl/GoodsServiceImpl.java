package com.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.domain.Goods;
import com.spring.domain.User;
import com.spring.service.GoodsServive;

public class GoodsServiceImpl implements GoodsServive {

	@Override
	@SuppressWarnings("unchecked")
	public String getGoods(HttpServletRequest request,String productid,String name,String baesprice){
		if((User)request.getSession().getAttribute("user")!=null){
		Goods goods = new Goods();
		goods.setProductid(productid);
		goods.setBaseprice(baesprice);
		goods.setName(name);
		Boolean flag = false;
		List <Goods> goodslist= null;
		if((List <Goods>)request.getSession().getAttribute("goodslist")==null){
			goodslist = new ArrayList<Goods>();
			goods.setAmount(1);
			goodslist.add(goods);
			request.getSession().setAttribute("goodslist", goodslist);
			System.out.println("session为空");
			return "shoppingCart";
		}else{
			goodslist = (List <Goods>)request.getSession().getAttribute("goodslist");
			if(goodslist.isEmpty()){
				goodslist = new ArrayList<Goods>();
				goods.setAmount(1);
				goodslist.add(goods);
				request.getSession().setAttribute("goodslist", goodslist);
				System.out.println("购物车为空");
				return "shoppingCart";
			}else{
				for(int i = 0;i<goodslist.size();i++){
					if(goodslist.get(i).getProductid().equals(productid)){
						
						goods.setAmount(goodslist.get(i).getAmount()+1);
						goodslist.set(i, goods);
						System.out .println(goods.getAmount());
						request.getSession().setAttribute("goodslist", goodslist);
						System.out.println("购物车中已有此商品");
						flag = true;
						return "shoppingCart";
					}
				}
				if (!flag) {
					goods.setAmount(1);
					goodslist.add(goods);
					request.getSession().setAttribute("goodslist", goodslist);
					System.out.println("购物车中没有此商品");
					return "shoppingCart";
				}
			}

		}
		return "shoppingCart";
		}
		else{
			return "login";
		}
	}

}
