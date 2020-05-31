package javaprgms;

import java.util.ArrayList;
import java.util.Arrays;

public class J006May19 {

	public static void main(String[] args) {
	
//	https://github.com/Bobpie/PractiseJavaPrograms
		
	//1. How to remove duplicates from a list?
		//		List = c
		
		 ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","A","D","E","F")); 
		 System.out.println("ArrayList with duplicates: " + list);
		  
		 ArrayList<String> newList = new ArrayList<String>(); 
		  
	        // Traverse through the first list 
	        for (String element : list) { 
	  
	            // If this element is not present in newList 
	            // then add it 
	            if (!newList.contains(element)) { 
	                newList.add(element); 
	            } 
	        } 
	     System.out.println("ArrayList without duplicates: " +newList);
	    System.out.println();
	    
	//2.How to retrieve a value from a Set?
		//		Set = "1,2,3,4,5,6,7,8,9" retrieve and print only the value 7
	    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	    System.out.println(list2);
	    for (Integer element : list2) {  
            if (element == 7) { 
                 System.out.println(element);
            } 
        }
	}

}
