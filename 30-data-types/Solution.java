import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);

		/* Declare second integer, double, and String variables. */
		int integerInput;
		double doubleInput;
		String stringInput;

		/* Read and save an integer, double, and String to your variables. */
		integerInput = scan.nextInt();
		doubleInput = scan.nextDouble();
		scan.nextLine();
		stringInput = scan.nextLine();

		/* Print the sum of both integer variables on a new line. */
		System.out.println(i + integerInput);

		/* Print the sum of the double variables on a new line. */
		System.out.println(d + doubleInput);

		/*
		 * Concatenate and print the String variables on a new line; the 's'
		 * variable above should be printed first.
		 */
		System.out.println(s + stringInput);

		scan.close();
	}
}
