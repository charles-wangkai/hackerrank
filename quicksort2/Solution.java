import java.util.ArrayList;
import java.util.List;
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

		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		int pivot = ar[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (ar[i] < pivot) {
				left.add(ar[i]);
			} else {
				right.add(ar[i]);
			}
		}

		int index = begin;
		for (int leftNumber : left) {
			ar[index] = leftNumber;
			index++;
		}
		ar[index] = pivot;
		index++;
		for (int rightNumber : right) {
			ar[index] = rightNumber;
			index++;
		}

		int pivotIndex = begin + left.size();
		quickSort(ar, begin, pivotIndex - 1);
		quickSort(ar, pivotIndex + 1, end);

		printNumbers(ar, begin, end);
	}

	static void printNumbers(int[] ar, int begin, int end) {
		boolean first = true;
		for (int i = begin; i <= end; i++) {
			if (!first) {
				System.out.print(" ");
			}
			System.out.print(ar[i]);

			first = false;
		}
		System.out.println();
	}
}
