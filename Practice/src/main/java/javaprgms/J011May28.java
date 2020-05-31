package javaprgms;

public class J011May28 {

	public static void main(String[] args) {
		//Swapping number without using 3rd varialble
		System.out.println("Swapping Numbers");
		int a = 5, b = 10;
		System.out.println("Before swap a is : "+ a + " ,b is : "+b );
		
		a = a+b;
		b = a- b;
		a = a- b;
		
		System.out.println("After  swap a is : "+ a + " ,b is : "+b );

		//Fibonacci Series
		System.out.println("Fibonacci Series");
		int n = 10;
		int n1 = 0, n2=1;
		String out = "";
		
		for (int i = 1;i <= n;i++)
		{
			System.out.print(n1 + " + ");
			out = out + n1 + ",";
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
		}
		System.out.println("");
		String[] arr = out.split(",");
		
		for (int i = arr.length-1;i>=0;i--)
			System.out.print(arr[i] + " > ");
		System.out.println("");
		
		//Armstrong Number
//		int a1 = 1000;
//		int temp =0;
//		System.out.println("Armstrong Numbers");
//		for (int i =0; i <=a1;i++)
//		{
//			 temp=i;
//			 int originalNumber = 0,remainder=0,result=0,nn=0;
//			 originalNumber = i;
//
//		        for (;originalNumber != 0; originalNumber /= 10, ++nn);
//
//		        originalNumber = i;
//
//		        for (;originalNumber != 0; originalNumber /= 10)
//		        {
//		            remainder = originalNumber % 10;
//		            result += Math.pow(remainder, nn);
//		        }
//			    if(temp==result) 
//			    	System.out.println(temp);  
//		}
		int n3, b1, sum = 0,rng = 1000;
        System.out.println("Armstrong numbers from 1 to " + rng + ":");
        
        for(int i = 1; i <= rng; i++)
        {
            n3 = i;
            while(n3 > 0)
            {
                b1 = n3 % 10;
                sum = sum + (b1 * b1 * b1);
                n3 = n3 / 10;
            }
            if(sum == i)
            {
                System.out.print(i+" ");
            }
            sum = 0;
        }
	}

}
