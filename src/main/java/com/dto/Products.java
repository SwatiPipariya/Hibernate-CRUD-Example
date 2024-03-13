package com.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {
     
	@Id
	private int productId;
	String productsName;
	int quantity;
	int price;
	
	
	public Products() {
		super();
	}
	public Products(int productId, String productsName, int quantity, int price) {
		super();
		this.productId = productId;
		this.productsName = productsName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productsName=" + productsName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	
	
}
