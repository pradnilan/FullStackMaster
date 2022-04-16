package myPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String subject;
		boolean isFound=false;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Subject"); 
		subject=scanner.nextLine();
		
		File file=new File("C:\\Programming\\Java\\SimpliLearn\\Day-07\\MyFiles\\Scores.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		
		String line=br.readLine();
		
		while(line!=null) {
			
			var data=line.split(",");
			if(data[0].equals(subject)) {
				System.out.println(data[1]);
				isFound=true;
				break;
			}
			line=br.readLine();
		}
		
		br.close();
		fr.close();
		
		if(isFound==false)System.out.println("Subject is not found");
		
	}

}
