package javaprgms;

import java.util.regex.Pattern;

public class J003May14 {

	public static void main(String[] args) {
	
	//1st Program
		String inpt1 = "balaji.chandrasekaran@testleaf.com";
		String inpt2 = "balaji.c@tunatap.co.uk";
		String inpt3 = "naveen e@tl.com";
		
//		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
//                "[a-zA-Z0-9_+&*-]+)*@" + 
//                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
//                "A-Z]{2,7}$"; 
		String emailRegex = "[a-zA-Z0-9._]+@[a-z0-9]+.[a-z.]+{2,}";
		
		Pattern pat = Pattern.compile(emailRegex);
		
		System.out.println("Program 1");
		if (pat.matcher(inpt1).matches()) System.out.println("Email address is valid : "+ inpt1);
		else System.out.println("Email address is not valid : "+ inpt1);
		
		if (pat.matcher(inpt2).matches()) System.out.println("Email address is valid : "+ inpt2);
		else System.out.println("Email address is not valid : "+ inpt2);
		
		if (pat.matcher(inpt3).matches()) System.out.println("Email address is valid : "+ inpt3);
		else System.out.println("Email address is not valid : "+ inpt3);
		System.out.println();
		
	//2nd Program
		String in1 = "Balaji1";
		String in2 = "Testleaf$123";
		String in = in1;
		System.out.println("Program 2");
		
			String reg = "[a-zA-Z0-9._$@]{8,}";
			Pattern pat1 = Pattern.compile(reg);
			if (pat1.matcher(in).matches()) System.out.println("String is valid : "+ in);
			else System.out.println("String is not valid : "+ in);
		
		in = in2;
			if (pat1.matcher(in).matches()) System.out.println("String is valid : "+ in);
			else System.out.println("String is not valid : "+ in);

	}

}
