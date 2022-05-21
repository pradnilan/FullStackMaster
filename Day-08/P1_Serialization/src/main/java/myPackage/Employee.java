package myPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	
		
		int id;
		String name;
		int salary;
		
		public Employee(int id, String name,int salary) {
			this.id=id;
			this.name=name;
			this.salary=salary;
		}
		
	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
	}
		
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Employee emp=new Employee(1,"Adam",5000);
		File f=new File("C:\\Programming\\Java\\SimpliLearn\\Day-08\\MyFiles\\Employees.txt");
		FileOutputStream fo=new FileOutputStream(f);
		ObjectOutputStream out=new ObjectOutputStream(fo);
		out.writeObject(emp);
		fo.close();
		out.close();
		
		//Deserialization
		FileInputStream fi=new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fi);
		
		Employee emp1=(Employee)in.readObject();
		System.out.println(emp1);
		fi.close();
		in.close();
		
	}

}
