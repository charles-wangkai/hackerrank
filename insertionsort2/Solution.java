import java.util.Scanner;

public class Solution {
	public static void insertionSortPart2(int[] ar) {
		// Fill up the code for the required logic here
		// Manipulate the array as required
		// The code for Input/Output is already provided

		for (int i = 1; i < ar.length; i++) {
			int number = ar[i];
			int index = i - 1;
			while (index >= 0 && ar[index] > number) {
				ar[index + 1] = ar[index];
				index--;
			}
			ar[index + 1] = number;

			printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
