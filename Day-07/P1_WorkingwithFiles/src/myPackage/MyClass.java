package myPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String subject;
		int marks;
		
		/*
		 * Scanner scanner=new Scanner(System.in);
		 * System.out.println("Enter Your Subject"); subject=scanner.nextLine();
		 * System.out.println("Enter Your Marks"); marks=scanner.nextInt();
		 * System.out.println("Subject: "+subject+"\n"+ "Marks: "+marks);
		 */
		
		File file=new File("C:\\Programming\\Java\\SimpliLearn\\Day-07\\MyFiles\\Scores.txt");
		FileReader fr=new FileReader(file);
		int i =fr.read();
		
		while(i!=-1) {
			System.out.print((char)i);
			i=fr.read();
		}
		
		fr.close();
		

	}

}
