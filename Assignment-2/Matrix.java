/*
Matrices
(a) WAP to multiply matrices of size m * n and n* p. Initialize the two matrices in
the code itself. (since taking input from the user is time consuming).
(b) Challenge: WAP to compute determinant of a square matrix, initialize the matrix
in the code itself.
Assume all entries in the matrix are integers for this assignment, however, in
solving real world problems you will encounter non-integer matrix.
(c) Challenge: WAP that displays randomly generates a matrix of M by N (where
M,N > 2), and then displays its elements in a spiral. e.g. if the matrix is

1 2 3
4 5 6
7 8 9

then the output of the program should be 1 2 3 6 9 8 7 4 5
 */

import java.util.Scanner;

public class Matrix {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\nMatrix Multiplication....\n");
		input_multiply();

		System.out.println("\n\n\nDeterminant of Square Matrix....");
		double res = inputDeterminant();
		System.out.println("Determinant of square matrix is : " + res);

		System.out.println("\n\n\nDisplay Matrix in spiral form....\n");
		dispalySpiral();

	}

	//Method to take input for matrix multiplication
	public static void input_multiply() {
		System.out.print("\nEnter the number of rows of matrix 1 : ");
		int m = scan.nextInt();
		System.out.print("\nEnter the number of coulmns of matrix 1 : ");
		int n = scan.nextInt();
		System.out.print("\nEnter the number of rows of matrix 2 : ");
		int o = scan.nextInt();
		System.out.print("\nEnter the number of coulmns of matrix 2 : ");
		int p = scan.nextInt();

		if (n != o) {
			System.out.println("\nMatrix Multiplication is not possible...");
			System.out.println("Number of column of Matrix 1 and Number of rows of Matrix 2 must be equal...");

			System.out.println("\nDo you want to enter the details again (Y/N) ?");
			String confirm = scan.next();
			if (confirm.equalsIgnoreCase("Y")) {
				input_multiply();
			} else {
				System.out.println("Bye Bye");
			}
		} else
			multiply(m, n, p);
	}

	//method to calculate matrix multiplication
	public static void multiply(int m, int n, int p) {
		int A[][] = new int[m][n];
		int B[][] = new int[n][p];
		int C[][] = new int[m][p];

		System.out.println("\nEnter Elements of Matrix 1 : \n");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("A[" + i + "][" + j + "] : ");
				A[i][j] = scan.nextInt();
			}
		}

		System.out.println("\nEnter Elements of Matrix 2 : \n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				System.out.print("B[" + i + "][" + j + "] : ");
				B[i][j] = scan.nextInt();
			}
		}

		System.out.println("\nMultiplication of Matrices is : \n");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
				}
				System.out.print(C[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	//mathood to take input for Determinant
	public static double inputDeterminant() {
		System.out.println("\nEnter the number of row or column : ");
		int n = scan.nextInt();
		int A[][] = new int[n][n];
		System.out.println("Enter Matrix 1 : \n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("A[" + i + "][" + j + "] : ");
				A[i][j] = scan.nextInt();
			}
		}
		double res = determinant(A);
		return res;
	}

	
	//method to calculate determinant
	public static double determinant(int A[][]) {

		double res = 0, sign;

		if (A.length == 1) 
		{
			return (A[0][0]);
		}

		for (int i = 0; i < A.length; i++) 
		{
			int[][] B = new int[A.length - 1][A.length - 1];
			for (int j = 1; j < A.length; j++) 
			{
				for (int k = 0; k < A.length; k++) 
				{
					if (k < i) 
					{
						B[j - 1][k] = A[j][k];
					} 
					else 
					{
						if (k > i) 
						{
							B[j - 1][k - 1] = A[j][k];
						}
					}
				}
			}
			if (i % 2 == 0) 
				sign = 1;
			else
				sign = -1;
			res = res + (sign * A[0][i] * (determinant(B))); 
		}
	    return res; 
	}

	//method to display matrix as spiral
	public static void dispalySpiral() {

		System.out.print("Enter the number of rows of matrix : ");
		int l_row = scan.nextInt();
		System.out.print("\nEnter the number of coulmns of matrix : ");
		int l_col = scan.nextInt();
		int row = 0, col = 0;
		int mat[][] = new int[l_row][l_col];

		int i, j;
		System.out.print("\nEnter the matrix elements row-wise : \n");
		for (i = 0; i < l_row; i++) {
			for (j = 0; j < l_col; j++) {
				System.out.print("mat[" + i + "][" + j + "] : ");
				mat[i][j] = scan.nextInt();
			}
		}

		System.out.println("\nMatrix entered by you is : \n");
		for (i = 0; i < l_row; i++) {
			for (j = 0; j < l_col; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("Spiral Display of Matrix is : \n");

		while (row < l_row && col < l_col) {

			for (i = col; i < l_col; i++) {
				System.out.print(mat[row][i] + "\t");
			}
			row++;

			for (i = row; i < l_row; i++) {
				System.out.print(mat[i][l_col - 1] + "\t");
			}
			l_col--;

			if (row < l_row)
				for (i = l_col - 1; i >= col; i--) {
					System.out.print(mat[l_row - 1][i] + "\t");
				}
			l_row--;

			if (col < l_col)
				for (i = l_row - 1; i >= row; i--) {
					System.out.print(mat[i][col] + "\t");
				}
			col++;

		} // end while

	} // end displaySpiral

} // end class