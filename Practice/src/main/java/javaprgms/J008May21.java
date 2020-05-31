package javaprgms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class J008May21 {

	public static void main(String[] args) {
		
		String inpt = "Karma is powerful than God";
		Map<Character, Integer> baseMap = new LinkedHashMap<Character, Integer>();  
        char[] charArray = inpt.toCharArray();  
        for (Character ch : charArray) {  
            if (baseMap.containsKey(ch)) {  
                baseMap.put(ch, baseMap.get(ch) + 1);  
            } else {  
                baseMap.put(ch, 1);  
            }  
        }  
        System.out.println(baseMap);
        Set<Character> keys = baseMap.keySet();  
        for (Character ch : keys) {    
                System.out.println(ch + "  = " + baseMap.get(ch));  
        }  
	}

}
