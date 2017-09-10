/*Palindromes
(a) WAP that takes a string from user and prints out if the string is palindrome or
not. Examples of palindrome are "1213121","hannah". Palindromes are strings
with a property that they read the same forwards and backwards.
(b) WAP that takes a string from user and end out it longest palindromic substring.
(c) Challenge: A string is \almost palindrome" if by removing exactly 1 character
from it, the string becomes palindrome. e.g. \acbc" is almost palindrome be-
cause removing first 'a', string becomes palindrome ("cbc"). And "abcd" is not
an "almost palindrome" because it can not be made a palindrome by removing
exactly one character from it.
 */

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		//check string is palindrome or not
		System.out.print("\nEnter the String to check whether string is Palindrome or not : ");
		String str = scan.nextLine();
		boolean check = isPalindrome(str);
		if (check == true)
			System.out.println("\n'"+str + "' is a Palindrome String");
		else
			System.out.println("\n'"+str + "' is Not a Palindrome String");

		//Longest palindrome substring
		System.out.print("\nEnter the String to find longest Palindromic Substring : ");
		String str1 = scan.nextLine();
		longestPalindrome(str1);

		//make string palindrome
		System.out.print("\nEnter the almost Palindromic String to make it Palindromic string : ");
		String str2 = scan.nextLine();
		makePalindrome(str2);

	}
	

	//method to check string is palindrome or not
	public static boolean isPalindrome(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i > -1; i--) {
			reverse = reverse + str.charAt(i);
		}
		if (reverse.equals(str))
			return true;
		else
			return false;
	}

	
	//method to find Longest palindrome substring
	public static void longestPalindrome(String str) {
		int r = 0, l = 0;
		String curr = "", longest = "";
		for (int i = 1; i < str.length() - 1; i++) {
			l = i - 1;
			r = i + 1;
			while (l >= 0 && r < str.length()) {
				if (str.charAt(l) != str.charAt(r)) {
					break;
				}
				curr = str.substring(l, r + 1);

				if (curr.length() > longest.length())
					longest = curr;
				l--;
				r++;
			}
		}
		System.out.println("\nLongest Palindromic String in String '" + str + "' is : " + longest);
	}

	
	//method to make string palindrome
	public static void makePalindrome(String str) {
		String curr = "";
		
		char c[] = str.toCharArray();
		char b[] = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int k = 0;
			for (int j = 0; j < str.length(); j++) {
				if (j != i) {
					b[k] = c[j];
					k++;
				}
			}

			//copy b in curr
			curr = String.copyValueOf(b);

			//copy curr in sb
			StringBuilder sb = new StringBuilder(curr);

			//find index of null charcater
			int index = curr.indexOf('\0');

			//delete null character from sb
			sb.deleteCharAt(index);

			//copy sb in curr
			curr = sb.toString();

			//call check palindrome
			boolean check = isPalindrome(curr);

			//if true then break and print result
			if (check == true) {
				break;
			}
		}
		
		System.out.println("\nPalindromic string will be : " + curr);

	}
}