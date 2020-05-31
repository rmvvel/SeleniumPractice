package javaprgms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class J007May20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> baseMap = new LinkedHashMap<Character, Integer>();    
        baseMap.put('A', 1);  
        baseMap.put('B', 2);
        baseMap.put('C', 3);
        baseMap.put('D', 4);
        baseMap.put('E', 5);
        
        //Method 1
        System.out.println("Method 1");
        System.out.println(baseMap);
        System.out.println("");
        
        //Method 2
        System.out.println("Method 2");
        for (Entry<Character, Integer> entry : baseMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("");
        
        //Method 3
        System.out.println("Method 3");
        baseMap.forEach((eachKey,eachValue)->System.out.println(eachKey + " -- "+eachValue));
        System.out.println("");
        
        //Method 4
        System.out.println("Method 4");
        Iterator<Entry<Character,Integer>> It= baseMap.entrySet().iterator();
        It.forEachRemaining((eachEntry)->System.out.println(eachEntry.getKey()+ " ~~ "+eachEntry.getValue()));
        System.out.println("");
        
        //Method 5
        System.out.println("Method 5");
        Iterator<Entry<Character,Integer>> It1= baseMap.entrySet().iterator();
        while(It1.hasNext())
        	{
        		Entry<Character,Integer> eachE = It1.next();
        		System.out.println(eachE.getKey()+ " -> "+eachE.getValue());
        	}
        System.out.println("");
        
//	      Iterator it = baseMap.entrySet().iterator();
//	      while (it.hasNext()) {
//	          Map.Entry pair = (Map.Entry)it.next();
//	          System.out.println(pair.getKey() + " = " + pair.getValue());
//	          it.remove(); // avoids a ConcurrentModificationException
//	      }  
//	    System.out.println("");
	    
        //Method 6
        System.out.println("Method 6");
        baseMap.keySet().forEach((eachKey)->System.out.println(eachKey + " -- "+ baseMap.get(eachKey)));
        System.out.println("");
        
        Set<Character> keys = baseMap.keySet();  
        for (Character ch : keys) {  
            System.out.println(ch + "  -> " + baseMap.get(ch));    
        }   
        System.out.println("");
        
        //To modify value in Map
        baseMap.entrySet().forEach((eachEntry)->
        {
        	if (eachEntry.getKey().equals('A')||eachEntry.getKey().equals('C'))
        	{
        		eachEntry.setValue(10);
        	}
        	else baseMap.put(eachEntry.getKey(),20);
        });
        System.out.println(baseMap);
	}

}
