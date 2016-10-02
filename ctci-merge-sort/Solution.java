import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();
		for (int tc = 0; tc < d; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(countInversions(a, 0, a.length - 1));
		}

		sc.close();
	}

	static long countInversions(int[] a, int beginIndex, int endIndex) {
		if (beginIndex >= endIndex) {
			return 0;
		}

		long inversionNum = 0;
		int middleIndex = (beginIndex + endIndex) / 2;
		inversionNum += countInversions(a, beginIndex, middleIndex);
		inversionNum += countInversions(a, middleIndex + 1, endIndex);

		int leftIndex = beginIndex;
		int rightIndex = middleIndex + 1;
		int[] sorted = new int[endIndex - beginIndex + 1];
		for (int i = 0; i < sorted.length; i++) {
			if (rightIndex > endIndex || (leftIndex <= middleIndex && a[leftIndex] <= a[rightIndex])) {
				sorted[i] = a[leftIndex];
				leftIndex++;
			} else {
				inversionNum += middleIndex - leftIndex + 1;

				sorted[i] = a[rightIndex];
				rightIndex++;
			}
		}

		for (int i = beginIndex; i <= endIndex; i++) {
			a[i] = sorted[i - beginIndex];
		}

		return inversionNum;
	}
}
