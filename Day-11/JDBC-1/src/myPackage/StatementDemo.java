package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {


	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytrgdb",
					"root",
					"mko0bhu8CFT&");
			
			Statement statement=connection.createStatement(); //statement in statement class & database info in connection class
			
			String insert="insert into studentdata values(102,'NIshadi','Madushika',6,'B+')";
			String update="update studentdata set standard=11 where roll_no=102 ";
			String delete="delete from studentdata where roll_no=101";
			
			//int val=statement.executeUpdate(insert);
			
			//int val=statement.executeUpdate(update);
			
			int val=statement.executeUpdate(delete);
		
			
			System.out.println(val);
					
			if (val>0) System.out.println("Record inserted");
			else System.out.println("Record not inserted");
			
			connection.close();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
