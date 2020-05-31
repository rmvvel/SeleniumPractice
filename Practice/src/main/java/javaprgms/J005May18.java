package javaprgms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class J005May18 {

	public static void main(String[] args) {
	
	//1st Program
		System.out.println("Program 1");
		String inpt = "When life gives you lemons, make lemonade";
		Map<Character, Integer> baseMap = new HashMap<Character, Integer>();  
        char[] charArray = inpt.toCharArray();  
        for (Character ch : charArray) {  
            if (baseMap.containsKey(ch)) {  
                baseMap.put(ch, baseMap.get(ch) + 1);  
            } else {  
                baseMap.put(ch, 1);  
            }  
        }  
        Set<Character> keys = baseMap.keySet();  
        for (Character ch : keys) {  
            if (baseMap.get(ch) > 1) {  
                System.out.println(ch + "  is " + baseMap.get(ch) + " times");  
            }  
        }  
        System.out.println();
		
    //2nd program
        // Write a java program to print the list
        // Input : [B,u,g,a,t,t,i, , C,h,i,r,o,n]
        System.out.println("Program 2");
        List<String> li = new ArrayList<String>(Arrays.asList("B","u","g","a","t","t","i"," "," C","h","i","r","o","n"));
        System.out.println(li);
        
        
	}

}
