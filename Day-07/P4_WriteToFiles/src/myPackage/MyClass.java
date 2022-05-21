package myPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class MyClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f=new File("C:\\Programming\\Java\\SimpliLearn\\Day-07\\MyFiles\\Scores_Write.txt");
		FileWriter fw=new FileWriter(f,true); //t if you want to append the existing file
		fw.write("French"+","+"80"+"\n");	
		fw.close();
		
	}

}
