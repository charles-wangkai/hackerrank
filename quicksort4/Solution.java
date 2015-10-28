import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int shiftNum;
	static int swapNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		insertionSort(Arrays.copyOf(ar, ar.length));
		quickSort(Arrays.copyOf(ar, ar.length));
		System.out.println(shiftNum - swapNum);

		sc.close();
	}

	static void insertionSort(int[] A) {
		shiftNum = 0;
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				j = j - 1;
				shiftNum++;
			}
			A[j + 1] = value;
		}
	}

	static void quickSort(int[] ar) {
		swapNum = 0;
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
		int rightIndex = begin;
		for (int i = begin; i < end; i++) {
			if (ar[i] < pivot) {
				swap(ar, rightIndex, i);
				rightIndex++;
			}
		}
		swap(ar, rightIndex, end);

		return rightIndex;
	}

	static void swap(int[] ar, int index1, int index2) {
		int temp = ar[index1];
		ar[index1] = ar[index2];
		ar[index2] = temp;

		swapNum++;
	}
}
