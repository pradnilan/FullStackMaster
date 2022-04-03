package myPackage;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variable declaration
		int num;
		String results;
		
		System.out.println("Enter Number:");
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		
		/*
		 * if(num%2==0) results="Even Number"; else results="Odd Number";
		 */
		
		results=(num%2==0)?"Even Number":"Odd Number";
		
		System.out.println(results);
		
		scanner.close();

	}

}
