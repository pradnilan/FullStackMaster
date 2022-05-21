package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytrgdb",
					"root",
					"mko0bhu8CFT&");
			
			/*
			 * String query="insert into studentdata values(?,?,?,?,?)";
			 * 
			 * PreparedStatement ps=connection.prepareStatement(query); ps.setInt(1, 105);
			 * ps.setString(2,"Bethmage"); ps.setString(3,"Richard"); ps.setInt(4, 5);
			 * ps.setString(5,"C-");
			 */
			
			String query="delete from studentdata where roll_no = ?";
			 
			 PreparedStatement ps=connection.prepareStatement(query);
			
			 ps.setInt(1, 102);
			
			
			int val=ps.executeUpdate();
			
			if (val>0) System.out.println("Record inserted");
			else System.out.println("Record not inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
