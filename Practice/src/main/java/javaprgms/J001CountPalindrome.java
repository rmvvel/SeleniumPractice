package javaprgms;

public class J001CountPalindrome {

	public static void main(String[] args) {
	
	//--------------------------------------------------------------------------------------------
	//1st Program
	//--------------------------------------------------------------------------------------------
	     String inpt = "You have no choice other than following me";
	     char[] a1 = inpt.toCharArray();
	     int cnt = 0;
	     for (int i = 0; i < a1.length ; i++ )
	     {
	    	 if (a1[i] == 'o')
	    	 {
	    		 cnt = cnt +1;
	    	 }
	     }
			System.out.println("Occurance if o is : "+ cnt);
		
		//replace all characters except o - 2nd approach
			String rep = inpt.replaceAll("[^o]", "");
			System.out.println("Occurance using regular expression : "+rep.length());
			
	//--------------------------------------------------------------------------------------------	
	//2nd Program
	//--------------------------------------------------------------------------------------------
		String inpt1 = "malayalam";
		String inpt2 = "testleaf";
		char[] a2 = inpt1.toCharArray();
		char[] a3 = inpt2.toCharArray();
		String tmp = "";
		String tmp1 = "";
		
		for (int i =(a2.length-1) ; i >= 0 ; i -- )
		{
			tmp += a2[i];
		}
		System.out.println("tmp is : "+ tmp);
		for (int i =(a3.length -1) ; i >= 0 ; i -- )
		{
			tmp1 += a3[i];
		}
		System.out.println("tmp1 is : "+ tmp1);
//		if (inpt1.contentEquals(tmp)) System.out.println("Palindrome : "+ inpt1);
//		else System.out.println("Not Palindrome : "+ inpt1);
		System.out.println(inpt1.contentEquals(tmp)?"Palindrome :"+inpt1:"Not Palindrome : "+inpt1);
		
		if (inpt2.contentEquals(tmp1)) System.out.println("Palindrome : "+ inpt2);
		else System.out.println("Not Palindrome : "+ inpt2);
		
		// 2nd approach - using StringBuffer
		StringBuffer i1 = new StringBuffer(inpt1);
		String rev = i1.reverse().toString();
		System.out.println(inpt1.contentEquals(rev)?"Palindrome :"+inpt1:"Not Palindrome : "+inpt1);
		
	}
}
