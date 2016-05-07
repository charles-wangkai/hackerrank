import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int swapNum = bubbleSort(a);
		System.out.println("Array is sorted in " + swapNum + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);

		sc.close();
	}

	static int bubbleSort(int[] a) {
		int swapNum = 0;

		for (int i = 0; i < a.length; i++) {
			int numberOfSwaps = 0;

			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					numberOfSwaps++;
				}
			}

			if (numberOfSwaps == 0) {
				break;
			}

			swapNum += numberOfSwaps;
		}

		return swapNum;
	}

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
