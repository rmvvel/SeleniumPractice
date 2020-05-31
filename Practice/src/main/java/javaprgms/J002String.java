package javaprgms;

public class J002String {

	public static void main(String[] args) {
	
	// 1st Program	
		String inpt = "asdf1qwer9as8d7";
		int sum = 0;
		
		for (int i =0 ; i < inpt.length();i++)
		{
			if (Character.isDigit(inpt.charAt(i)))
			{
				sum += Integer.parseInt(String.valueOf(inpt.charAt(i)));
			}
		}
		System.out.println("Program 1");
		System.out.println("Input : "+inpt);
		System.out.println("Sum is : "+sum);
		System.out.println();

	//2nd Program
		String inpt1 = "When the world realise its own mistake, corona will dissolve automatically";
		String[] arr1 = inpt1.split(" ");
		String out = "";
		for (int i = 0; i < arr1.length;i++)
		{
			if (i % 2 == 0) out = out + arr1[i] + " ";
			else
			{
				StringBuffer i1 = new StringBuffer(arr1[i]);
				String rev = i1.reverse().toString();
				out = out + rev + " " ;
			}
			
		}
		System.out.println("Program 2");
		System.out.println(inpt1);
		System.out.println(out);
		System.out.println();
		
	//3rd Program
		String inpt2 = "1. It is Work from Home not Work for Home";
		int num = 0;
		int up = 0;
		int low = 0;
		int spc = 0;
		int otr = 0;
		for (int i =0 ; i < inpt2.length();i++)
		{
			if (Character.isDigit(inpt2.charAt(i))) num ++;
			else if (Character.isUpperCase(inpt2.charAt(i))) up++;
			else if (Character.isLowerCase(inpt2.charAt(i))) low++;
			else if (inpt2.charAt(i)==' ') spc++;
			else otr++;
		}
		System.out.println("Program 3");
		System.out.println("Input : "+inpt2);
		System.out.println("Count of Numbers : " +num);
		System.out.println("Count of Upper cases : " + up);
		System.out.println("Count of lower cases : " + low);
		System.out.println("Count of spaces : " + spc);
		System.out.println("Count of others : " + otr);
	}
}