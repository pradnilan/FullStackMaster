package com.simplilearn.trg.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.simplilearn.trg.jdbc.dto.Product;
import com.simplilearn.trg.jdbc.util.ConnectionManagerImpl;

public class ProductDaoImpl implements ProductDao {

	private Connection connection;
	
	public ProductDaoImpl() {
		connection=new ConnectionManagerImpl().getConnection();
	}
	
	@Override
	public boolean addProduct(Product product) {
		
		boolean isProductAdded=false;
		
		String query="insert into products values(?,?,?)";
		
		PreparedStatement ps;
		
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,product.getProduct_id());
			ps.setString(2,product.getProducname());
			ps.setDouble(3,product.getProduct_cost());
			
			int val=ps.executeUpdate();
			
			if(val>0) isProductAdded=true;
			else isProductAdded=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return isProductAdded;
	}

	@Override
	public boolean updateProductCost(int productId, double productCost) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Product> getAllProducts() {
		Set<Product> products=new HashSet<Product>();
		
        String query="select * from products";
		
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			
			while(rs.next()) {
				
				/*
				 * Product product=new Product(); product.setProduct_id(rs.getInt(1));
				 * product.setProducname(rs.getString(2));
				 * product.setProduct_cost(rs.getDouble(3));
				 */
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				products.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return products;
	}

	@Override
	public Product searchProductById(int productId) {
		
		Product product=null;
		String query="select * from products where product_id = ? ";
		
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,productId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			product=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Product searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
