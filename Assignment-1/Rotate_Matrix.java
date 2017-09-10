/*
Write a function int ** rotateMatrix(int **inputMatrix, int m , int n, int k),
that takes an input matrix named inputMatrix of size m by n (where m and n both
are positive even numbers) and returns a matrix with each element rotated k times.
*/

import java.util.Scanner;

public class Rotate_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Variables
		int l_row, l_col, i, j;

		// Standard Input
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// input number of rows and column
		System.out.print("\nEnter the number of rows you want to insert : ");
		l_row = scan.nextInt();
		System.out.print("\nEnter the number of column you want to insert : ");
		l_col = scan.nextInt();

		// create matrix
		int mat[][] = new int[l_row][l_col];

		// input elements of matrix
		System.out.print("\nEnter the matrix elements row-wise : \n");
		for (i = 0; i < l_row; i++) {
			for (j = 0; j < l_col; j++) {
				System.out.print("mat[" + i + "][" + j + "] : ");
				mat[i][j] = scan.nextInt();
			}
		}

		// print entered matrix
		System.out.println("\nMatrix entered by you is : \n");
		for (i = 0; i < l_row; i++) {
			for (j = 0; j < l_col; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println("\n");
		}

		// input number of rotation
		System.out.print("How many times do you want to rotate matrix : ");
		int k = scan.nextInt();
		System.out.println();

		// call rotateMatrix method
		rotateMatrix(mat, l_row, l_col, k);

	}// end main

	// rotateMatrix Method Definition
	public static int rotateMatrix(int mat[][], int l_row, int l_col, int k) {
		// variables
		int row = 0, col = 0, prev, curr, i, j;
		int l1 = l_row;
		int l2 = l_col;

		// loop for number of rotations
		for (int l = 1; l <= k; l++) {
			
			// loop for checking inner rings
			while (row < l_row && col < l_col) {
				
				// if single element exist in the center then break
				if (row + 1 == l_row && col + 1 == l_col)
					break;

				// store the value which is going to be place at first position of ring
				prev = mat[row + 1][col];

				// Shift first row of a ring (upper side elements)
				for (i = col; i < l_col; i++) {
					curr = mat[row][i];
					mat[row][i] = prev;
					prev = curr;
				}
				row++; // increment first row index for inner ring

				// Shift last column of a ring (right side elements)
				for (i = row; i < l_row; i++) {
					curr = mat[i][l_col - 1];
					mat[i][l_col - 1] = prev;
					prev = curr;
				}
				l_col--; // decrement last column index for inner ring

				// Shift last row of a ring (lower side elements)
				for (i = l_col - 1; i >= col; i--) {
					curr = mat[l_row - 1][i];
					mat[l_row - 1][i] = prev;
					prev = curr;
				}
				l_row--; // decrement last row index for inner ring

				// Shift first column of a ring (left side elements)
				for (i = l_row - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
				col++; // increment first column index for inner ring 
			}

			// print matrix after rotation
			System.out.println("After " + l + " rotation matrix is : \n");
			for (i = 0; i < l1; i++) {
				for (j = 0; j < l2; j++) {
					System.out.print(mat[i][j] + "\t");
				}
				System.out.println("\n");
			} // end while

			// reinitialize for number of rotation
			row = col = 0;
			l_row = l1;
			l_col = l2;
		} // end rotation loop
		return 0;
	} // end rotateMatrix
} // end class