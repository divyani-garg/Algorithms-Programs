
/*
Permutation
(a) WAP to take an integer from user and generate its next permutation,
(b) Modify above part a), that generates all permutations of the number from the beginning. (You may need sorting for this problem).
(c) Challenge: can you generate all permutations of smaller length? 
e.g. take number 123, all permutations of length 2 are 12,13,21,23,31,32. 
Take the number (like 123 in this example) and length of permutations (like 2 in this example) from user.
*/

import java.util.Scanner;

public class per_com {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the Number : ");
		int n = scan.nextInt();

		int size = String.valueOf(n).length();

		int arr[] = new int[size];

		for (int i = size - 1; i >= 0; i--) {
			arr[i] = n % 10;
			n = n / 10;
		}
		nextPermutation(arr, size);

		System.out.println("\n\nAll permuations are : ");
		allPermutation(arr, size, size);

		// input subset size
		System.out.println("\nEnter the Size of Subset you want : ");
		int ss = scan.nextInt();
		
		int data[] = new int[size];
		System.out.println("\nAll possible combination of size " + ss + " are : ");
		Combination(arr, data, 0, size - 1, 0, ss);

	}

	public static void nextPermutation(int arr[], int size) {
		System.out.print("\nThe next permuatation is : ");

		int temp = arr[size - 2];
		arr[size - 2] = arr[size - 1];
		arr[size - 1] = temp;

		for (int i = 0; i < size; i++)
			System.out.print(arr[i]);
	}

	public static void print(int arr[], int n) {
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void allPermutation(int arr[], int size, int n) {
		if (size == 1) {
			print(arr, n);
			return;
		}
		for (int i = 0; i <= size - 1; i++) {
			swap(arr, i, size - 1);
			allPermutation(arr, size - 1, n);
			swap(arr, i, size - 1);
		}
	}

	public static void Combination(int arr[], int data[], int start, int end, int index, int ss) {
		// check if a combination generated then print
		if (index == ss) {
			for (int j = 0; j < ss; j++)
				System.out.print(data[j] + " ");
			System.out.print("\n");
		}

		// put values of array into data while recursively calling printCombination by increasing start index of both arrays
		for (int i = start; i <= end; i++) {
			data[index] = arr[i];
			Combination(arr, data, i + 1, end, index + 1, ss);
		}
	}
}
