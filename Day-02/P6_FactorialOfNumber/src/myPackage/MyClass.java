package myPackage;

import java.util.Scanner;

public class MyClass {
	
		
	public static void main(String[] args) {
		
		int num;
		int result=1;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Any Number:");
		
		num=scanner.nextInt();
		
		for(int i=num;i>0;i--) result*=i;
		System.out.println("Factorial of "+num+" is "+result);
		scanner.close();
		
		
	}
	

}
