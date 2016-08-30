package com.spring.domain;

public class Goods {
	private String productid;
	private String name;
	private int amount;
	private String baseprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "Goods [productid=" + productid + ", name=" + name + ", amount=" + amount + ", baseprice=" + baseprice
				+ "]";
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(String baseprice) {
		this.baseprice = baseprice;
	}
	
}
