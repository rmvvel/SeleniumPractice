package javaprgms;

import java.util.Arrays;

public class J009May26 {

	public static void main(String[] args) {
		//Program to sort array and reverse it
		System.out.println("Program 1");
		int[] array = {5,1,33,79,22,11,45};
		//O/p sorted {1,5,11,22,33,45,79}
		//reversed : {79,45,33,22,11,5,1}
		
		Arrays.sort(array);
		for (int i = 0; i < array.length;i++)
		{
			System.out.print(array[i] + " -- ");
		}
		System.out.println("");
		for (int i = array.length-1 ; i >=0 ;i--)
		{
			System.out.print(array[i] + " -- ");
		}
		System.out.println();
		//Progarm to find average of numbers in array
		int[] array2 = {20,30,25,35,-16,60,-100};
		//O/p average is 7
		System.out.println("Program 2");
		int sum = 0;
		for (int i = 0; i < array2.length;i++)
		{
			sum = sum + array2[i];
		}
		System.out.println("Average is : "+ (sum/(array2.length)));
		System.out.println();
		
		//Progarm to print common numbers in 2 array
		int[] array3 = {1,2,5,5,8,9,7,10};
		int[] array4 = {1,0,6,15,6,4,7,0};
		System.out.println("Program 3");
		System.out.println("Program 3 - Common Elements in 2 Arrays");
		for(int i = 0; i < array3.length; i++){
            for(int j = 0; j < array4.length; j++){
                if(array3[i] == array4[j]){
                    System.out.print(array3[i] + " ");
                    break;
                }
            }
        }
		
	}

}
