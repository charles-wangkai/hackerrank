import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = in.nextInt();
		}

		quickSort(ar);

		in.close();
	}

	static void quickSort(int[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	static void quickSort(int[] ar, int begin, int end) {
		if (end <= begin) {
			return;
		}

		int pivotIndex = partition(ar, begin, end);
		quickSort(ar, begin, pivotIndex - 1);
		quickSort(ar, pivotIndex + 1, end);
	}

	static int partition(int[] ar, int begin, int end) {
		int pivot = ar[end];
		int rightIndex = 0;
		for (int i = 0; i < end; i++) {
			if (ar[i] < pivot) {
				swap(ar, rightIndex, i);
				rightIndex++;
			}
		}
		swap(ar, rightIndex, end);

		printNumbers(ar);

		return rightIndex;
	}

	static void swap(int[] ar, int index1, int index2) {
		int temp = ar[index1];
		ar[index1] = ar[index2];
		ar[index2] = temp;
	}

	static void printNumbers(int[] ar) {
		boolean first = true;
		for (int i = 0; i < ar.length; i++) {
			if (!first) {
				System.out.print(" ");
			}
			System.out.print(ar[i]);

			first = false;
		}
		System.out.println();
	}
}
