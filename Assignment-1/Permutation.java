/*
Permutations:
WAP that generates all permutations of a number. For example, all permutations of number 312 are 123,132,213,231,312 and 321.
*/

import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number : ");
		int n = scan.nextInt();
		int size = String.valueOf(n).length();

		int arr[] = new int[size];

		for (int i = size-1 ; i >= 0; i--) {
			arr[i] = n % 10;
			n = n / 10;
		}
		permu(arr, size, size);
	}

	public static void print(int arr[], int n) {
		for (int i = n-1 ; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void permu(int arr[], int size, int n) {
		if (size == 1) {
			print(arr, n);
			return;
		}
		for (int i = 0; i <= size - 1; i++) {
			swap(arr, i, size - 1);
			permu(arr, size - 1, n);
			swap(arr, i, size - 1);
		}
	}
}