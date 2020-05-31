package javaprgms;

public class J012May29 {

	public static void main(String[] args) {
		
//		1. Java program to transpose the matrix
//		Actual Matrix
//		1 2 3
//		4 5 6
//		7 8 9
//		Tranposed Matrix
//		1 4 7
//		2 5 8
//		3 6 9
		System.out.println("Transpose of Matrix");
		int[][] a1 = new int[3][3];
		int[][] a2 = new int[3][3];
		a1[0][0] = 1; a1[0][1] = 2; a1[0][2] = 3;
		a1[1][0] = 4; a1[1][1] = 5; a1[1][2] = 6;
		a1[2][0] = 7; a1[2][1] = 8; a1[2][2] = 9;
				
		for (int i = 0; i <=2 ; i ++)
		{
			for (int j = 0 ; j <=2; j++)
			{
				a2[i][j] = a1[j][i]; 
			}
		}
		
		for (int i = 0; i <=2 ; i ++)
		{
			for (int j = 0 ; j <=2; j++)
			{
				System.out.print(a2[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		2.Write a java program to add 2 matrices
//		Matrices 1
//		1 2 3
//		4 5 6
//		7 8 9
//		Matrices 2
//		9 8 7 
//		6 5 4
//		3 2 1
//		Solution
//		10 10 10 
//		10 10 10
//		10 10 10
		
		System.out.println("Sum of Matrix");
		int[][] b1 = new int[3][3];
		int[][] b2 = new int[3][3];
		int[][] b3 = new int[3][3];
		b1[0][0] = 1; b1[0][1] = 2; b1[0][2] = 3;
		b1[1][0] = 4; b1[1][1] = 5; b1[1][2] = 6;
		b1[2][0] = 7; b1[2][1] = 8; b1[2][2] = 9;
		
		b2[0][0] = 9; b2[0][1] = 8; b2[0][2] = 7;
		b2[1][0] = 6; b2[1][1] = 5; b2[1][2] = 4;
		b2[2][0] = 3; b2[2][1] = 2; b2[2][2] = 1;
		
		for (int i = 0; i <=2 ; i ++)
		{
			for (int j = 0 ; j <=2; j++)
			{
				b3[i][j] = b1[i][j] + b2[i][j];
				System.out.print(b3[i][j]+ " ");
			}
			System.out.println();
		}

	}

}
