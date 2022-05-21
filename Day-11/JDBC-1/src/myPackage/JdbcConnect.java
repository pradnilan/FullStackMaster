package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {

	public static void main(String[] args) {
		
		
		try {
			
			//1. Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Establish the connection with database
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytrgdb",
					"root",
					"mko0bhu8CFT&");
			System.out.println("Connected to database");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
