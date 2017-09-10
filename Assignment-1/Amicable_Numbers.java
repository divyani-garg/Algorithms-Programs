/*
Amicable numbers:
WAP that takes two numbers and finds out if they are amicable numbers or not.
Amicable numbers are two different numbers so related that the sum of the proper divisors of each is equal to the other number.
For example, the smallest pair of amicable numbers is (220, 284). 
They are amicable because the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110, of
which the sum is 284; and the proper divisors of 284 are 1, 2, 4, 71 and 142, of which the sum is 220.
 */

import java.util.Scanner;

public class Amicable_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variables
		int n1, n2, i, sum1 = 0, sum2 = 0;

		//Standard Input Object
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// Take two numbers as input from user
		System.out.println("Enter the First Number : ");
		n1 = scan.nextInt();
		System.out.println("Enter the Second Number : ");
		n2 = scan.nextInt();

		// Calculate for first number n1
		for (i = 1; i <= n1 / 2; i++) {
			if (n1 % i == 0) {
				sum1 = sum1 + i;
			}
		}

		// Calculate for Second number n2
		for (i = 1; i <= n2 / 2; i++) {
			if (n2 % i == 0) {
				sum2 = sum2 + i;
			}
		}

		// Check and print result
		if (sum1 == n2 && sum2 == n1) {
			System.out.println(n1 + " and " + n2 + " are Amicable Numbers...!");
		} else
			System.out.println(n1 + " and " + n2 + " are not Amicable Numbers...!");
	} // end main
} // end class
