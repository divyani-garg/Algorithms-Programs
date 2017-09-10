/*
Consider following series:
sin(x) = x - x^3/3! + x^5/5! - ...... + x^199/199!
(a) Write a program that computes above series. You can you as many loops, user
depend function and library function as you like.
(b) Calculate how many multiplications, divisions, additions and subtractions your
program performs.
(c) Challenge: Can you find a method to reduce number of multiplication, division,
addition and subtraction operations performed by your program?
OR
(d) Challenge: Can you compute the same series with one loop only and without
using math library, without any user defined function (like int fact(int))? 
*/

public class Series2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x, sum = 1;
		int i;
		int c1=0,c2=0,c3=0;
		//sin 90 = 1 or sin pie/2 = 1 or x = 3.14/2
		x = 1.67;
		
		for (i = 199; i > 1; i -= 2) {
			
			//sum = 1 - sum * ( (x*x) / ( (i-1)*i ) );
			int j = i - 1;
			c1++;
			j = j * i ;
			c2++;
			double y = x * x;
			c2++;
			double z = y / j;
			c3++;
			double w = sum * z;
			c2++;
			sum = 1 - w;
			c1++;	
			
		}
		double res = sum * x;
		c2++;
     	System.out.println("\nSum of Series is : " + res);
     	System.out.println("\nNumber of Subtraction : " + c1);
     	System.out.println("\nNumber of Multiplication : " + c2);
     	System.out.println("\nNumber of Division : " + c3);
	}
}