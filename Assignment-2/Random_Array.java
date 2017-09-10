/*
Randomly generate an array of 1000 elements, each element has values from 0 to 100 (0 and 100 inclusive). 
You need to write following:
(a) a function "float findMean(int* inputArray, int n)" that takes the array as
input and returns mean of all the elements in the array
(b) a function "float findMedian(int* inputArray, int n)" that takes the array
as input and returns median of all the elements in the array. For this task you
may need to sort the array.
(c) a function "int** findFreqDist(int* inputArray, int n, int** outputArray)" that takes an array (inputArray) 
as input and returns frequency distribution of all the elements in the array. 
For this task you need to create a 2D array of size 101 by 2 (outputArray). 
Each row will be a pair of (number, count of that number). 
Since there are only 101 elements, therefore the size of the array is 101 by 2.
Note: `n' above is size of input array.
 */

import java.util.*;

public class Random_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		int[] array = new int[1000];

		for (int i = 0; i < array.length; i++)
			array[i] = r.nextInt(101);

		float res = findMean(array, 1000);
		System.out.println("Mean of Randomly generated array is : " + res);

		float res1 = findMedian(array, 1000);
		System.out.println("Median of Randomly generated array is : " + res1);

		System.out.println("Frequency Distribution : " );
		int[][] outputArray = findFreqDist(array, 1000);
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(outputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static float findMean(int inputArray[], int n) {
		float sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + inputArray[i];
		}
		return sum / n;
	}

	public static float findMedian(int Array[], int n) {

		int[] inputArray = sort(Array, n);
		int mid = n / 2;
		float median = (inputArray[mid - 1] + inputArray[mid]) / 2;
		return median;
	}

	public static int[][] findFreqDist(int[] Array, int n) {

		int[] inputArray = sort(Array, n);
		int outputArray[][] = new int[101][2];
		int count = 0;
		
		int k = 0;
		for (int i = 0; i < n;) {
			count = 1;
			for (int j = i + 1; j < n; j++) {
				if (inputArray[i] == inputArray[j])
					count++;
				else
					break;
			}
			outputArray[k][0] = inputArray[i];
			outputArray[k][1] = count;
			k++;
			i += count;
		}
		return outputArray;
	}
	
	public static int[] sort(int [] inputArray, int n)
	{
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (inputArray[j - 1] > inputArray[j]) {
					temp = inputArray[j - 1];
					inputArray[j - 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;
	}
}
