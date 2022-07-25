package com.simplilearn.trg.jdbc.dto;

public class Product {
	
	private int product_id;
	private String producname;
	private double product_cost;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
		
	 public Product(int product_id, String producname, double product_cost) {
		super();
		this.product_id = product_id;
		this.producname = producname;
		this.product_cost = product_cost;
	}

	public String getProducname() {
		return producname;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public double getProduct_cost() {
		return product_cost;
	}

	public void setProduct_cost(double product_cost) {
		this.product_cost = product_cost;
	}

	public void setProducname(String producname) {
		this.producname = producname;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", producname=" + producname + ", product_cost=" + product_cost
				+ "]";
	}
	 
	
}
