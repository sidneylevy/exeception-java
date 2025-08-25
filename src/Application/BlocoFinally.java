 package Application;
 
 import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
 import java.util.Scanner;
	 public class BlocoFinally{
	 public static void main(String[] args) {
		 
	 File file= new File("C:\\temp\\in.txt"); //"C:\\jogos\\criandoApp\\como organizar o codigo.txt"
	 Scanner sc = null;
	
	 try{
	 sc = new Scanner(file);
	 while(sc.hasNextLine()) {
	  System.out.println(sc.nextLine());
	  
	 }
	 
	 } 
	 catch(FileNotFoundException e) {
	  System.out.println("Error opening file: "+ e.getMessage());
	 
	 } 
	 finally{
	   if (sc!= null) {
		 sc.close();
	   }
	   System.out.println("Finally bloc executed!!");
	 }
	}
  }