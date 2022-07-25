package com.simplilearn.trg.jdbc.client;

import java.util.Set;

import com.simplilearn.trg.jdbc.dto.Product;
import com.simplilearn.trg.jdbc.service.ProductService;
import com.simplilearn.trg.jdbc.service.ProductServiceImpl;

public class Client {
	
	public static void main(String[] args) {
		
		Product product=new Product(2,"Tab", 40000);
		
		ProductService service=new ProductServiceImpl();
		
		//Add product
		
		/*
		 * boolean isProductAdded=service.addProduct(product);
		 * 
		 * if(isProductAdded) System.out.println("Product added successfully"); else
		 * System.out.println("Product not added");
		 */
		 
		
		//get all products
		
		  Set<Product> allProducts=service.getAllProducts();
		  System.out.println("All Products"); for(Product p:allProducts) {
		  System.out.println(p); }
		 
		
		//Search product by ID
		product=service.searchProductById(2);
		if(product!=null) System.out.println("\n"+"Product Id 2 is "+product);
		else System.out.println("Product does not exist");
		
	}
	

}
