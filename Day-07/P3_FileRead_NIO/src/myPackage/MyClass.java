package myPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path path;
		path=Paths.get("C:\\Programming\\Java\\SimpliLearn\\Day-07\\MyFiles\\Scores.txt");
		
		//Paths.get()
		
		var alllines=Files.readAllLines(path); 
		for (var r:alllines) System.out.println(r);
		
	}

}
