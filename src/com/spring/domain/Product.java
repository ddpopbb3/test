package com.spring.domain;

import java.math.BigDecimal;

public class Product{
    private Long productid;

    private String name;

    private String description;

    private BigDecimal baseprice;

    private Long categoryid;

    private String author;

    private String publish;

    private Integer pages;

    @Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", description=" + description + ", baseprice="
				+ baseprice + ", categoryid=" + categoryid + ", author=" + author + ", publish=" + publish + ", pages="
				+ pages + ", images=" + images + "]";
	}

	private String images;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(BigDecimal baseprice) {
        this.baseprice = baseprice;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}