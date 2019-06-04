package com.catolicasc.foodtruck.models;

public class OrderItem {
	Integer id;
	Double  quatity;
	Product product;
	Orders  order;
	Double  unit_price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getQuatity() {
		return quatity;
	}
	public void setQuatity(Double quatity) {
		this.quatity = quatity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}

	
}
