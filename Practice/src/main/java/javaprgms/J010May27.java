package javaprgms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class J010May27 {

	public static void main(String[] args) {
		
		int[] myarr = {1,2,5,5,6,6,7,2};
//		System.out.println("Duplicate elements from array using hash table"); 
		Map<Integer, Integer> nameAndCount = new HashMap<>(); 
		// build hash table with count 
		for (int name : myarr) 
		{ 
			Integer count = nameAndCount.get(name); 
			if (count == null) nameAndCount.put(name, 1); 
			else  nameAndCount.put(name, ++count);
		}
			// Print duplicate elements from array in Java 
			Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet(); 
			for (Entry<Integer, Integer> entry : entrySet) 
			{ 
				if (entry.getValue() > 1) System.out.println("Duplicate element from array : " + entry.getKey());
			}
	}
}

