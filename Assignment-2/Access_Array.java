
/*
Accessing Arrays
(a) WAP to print an input string in reverse order.
(b) WAP to replace all characters with another character, take the string, character
to replace and the character to substitute from user. e.g. string = "Hello World",
character to replace = 'o', replacing character = 'X', nal string = "HellX WXrld"
(c) Challenge: WAP to remove a character from the entire string. e.g. if string is
\how are you", and character 'o' is removed, nal string will be "hw are yu"
Note: using library functions from "strings.h" is not allowed.
 */

import java.util.Scanner;

public class Access_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// Reverse String
		System.out.print("Enter the String : ");
		String s = scan.nextLine();
		int size = s.length();
		char a[] = s.toCharArray();
		char b[] = new char[size];

		for (int i = size - 1, j = 0; i >= 0; i--, j++) {
			b[j] = a[i];
		}
		System.out.print("\nReverse String is : ");
		System.out.println(b);

		// Replace Character
		System.out.print("\nEnter the character you want to replace : ");
		char c = scan.next().charAt(0);
		System.out.print("\nEnter the character you want to put : ");
		char p = scan.next().charAt(0);

		for (int i = 0; i < size; i++) {
			if (b[i] == c) {
				b[i] = p;
			}
		}
		System.out.print("\nString Will Be : ");
		System.out.println(b);

		// Remove Character
		System.out.print("\nEnter the character you want to remove : ");
		char r = scan.next().charAt(0);
		System.out.print("\nString will be : ");
		for (int i = 0; i < size; i++) {
			if (b[i] != r) {
				System.out.print(b[i]);
			}
		}

	} // end main
} // end class