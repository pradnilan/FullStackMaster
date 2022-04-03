package myPackage;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Any Number:");
		
		num=scanner.nextInt();
		int i=0;
		for( i=2;i<num;i++)
			if(num%i==0) break; //loop execute few times only
		if (i==num)System.out.println(num+" is a prime number");
		else System.out.println(num+" is not a prime number");
		
		scanner.close();

	}

}
