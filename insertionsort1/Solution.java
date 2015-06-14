import java.util.Scanner;

public class Solution {
	// Fill up this function
	public static void insertIntoSorted(int[] ar) {
		int V = ar[ar.length - 1];
		int index = ar.length - 2;
		while (index >= 0 && ar[index] > V) {
			ar[index + 1] = ar[index];
			printArray(ar);
			index--;
		}
		ar[index + 1] = V;
		printArray(ar);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);

		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
