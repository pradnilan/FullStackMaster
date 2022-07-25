package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytrgdb",
					"root",
					"mko0bhu8CFT&");
			
			
			
			Statement statement=connection.createStatement();
			
			String query="select * from studentdata";
			
			ResultSet resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				int rollNo=resultSet.getInt(1);
				String fName=resultSet.getString("firest_name");
				String lName=resultSet.getString("last_name");
				int std=resultSet.getInt(4);
				String grade=resultSet.getString("grade");
				
				System.out.println(rollNo+","+fName+" "+lName+","+std+","+grade);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
