package base.api;

import java.io.File;

public class tempDelete {

	public static void deleteFolder(File file){
	      for (File subFile : file.listFiles()) {
	         if(subFile.isDirectory()) {
	            deleteFolder(subFile);
	         } else {
	            subFile.delete();
	         }
	      }
	      file.delete();
	   }
	   public static void main(String args[]) {
	      String filePath = "C:\\Users\\BM\\AppData\\Local\\Temp";
	      //Creating the File object
	      File file = new File(filePath);
	      deleteFolder(file);
	      System.out.println("Files deleted........");
	   }
}
