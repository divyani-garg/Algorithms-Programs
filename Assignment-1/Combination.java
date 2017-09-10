
/*
Combinations:
Write a function void printCombinations(int *array, int n, int m), where array is an integer array of size n and m is size of combination.
The function prints all nCm combinations of size m from the array.
Note: This problem can be solved either using recursion or using the solution of generating permutations.
*/

import java.util.Scanner;

public class Combination {

	// Main Class
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables
		int size, n, i;

		// Standard Input
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// input size of array
		System.out.print("\nEnter the Size of Array : ");
		size = scan.nextInt();

		// initialize array of given size
		int array[] = new int[size];
		int data[] = new int[size];

		// input element of array
		System.out.print("\nEnter the Elements of Array : \n");
		for (i = 0; i < size; i++) {
			System.out.print("Array[" + i + "] : ");
			array[i] = scan.nextInt();
		}

		// input subset size
		System.out.println("\nEnter the Size of Subset you want : ");
		n = scan.nextInt();

		System.out.println("\nAll possible combination of size " + n + " are : ");

		// Call printCombination method with both arrays and their start and end index respectively
		printCombination(array, data, 0, size - 1, 0, n);
	} // End Main

	// printCombination Method Definition
	public static void printCombination(int array[], int data[], int start, int end, int index, int n) {

		// check if a combination generated then print
		if (index == n) {
			for (int j = 0; j < n; j++)
				System.out.print(data[j] + " ");
			System.out.print("\t");
		}

		// put values of array into data while recursively calling printCombination by increasing start index of both arrays
		for (int i = start; i <= end; i++) {
			data[index] = array[i];
			printCombination(array, data, i + 1, end, index + 1, n);
		}
	} // End printCombination
} // End Class