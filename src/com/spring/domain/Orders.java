package com.spring.domain;

import java.math.BigDecimal;

public class Orders {
    private Integer orderid;

    private String name;

    private BigDecimal cost;

    private Integer userid;

    private Short statusid;

    private Short paywayid;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Short getStatusid() {
        return statusid;
    }

    public void setStatusid(Short statusid) {
        this.statusid = statusid;
    }

    public Short getPaywayid() {
        return paywayid;
    }

    public void setPaywayid(Short paywayid) {
        this.paywayid = paywayid;
    }
}