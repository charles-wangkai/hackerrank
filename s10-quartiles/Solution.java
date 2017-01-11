import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}

		Arrays.sort(x);

		int q2 = computeMedian(x, 0, n - 1);

		int lowerBound;
		int upperBound;
		if (n % 2 == 0) {
			lowerBound = n / 2 - 1;
			upperBound = n / 2;
		} else {
			lowerBound = n / 2 - 1;
			upperBound = n / 2 + 1;
		}

		int q1 = computeMedian(x, 0, lowerBound);
		int q3 = computeMedian(x, upperBound, n - 1);

		System.out.println(q1);
		System.out.println(q2);
		System.out.println(q3);

		sc.close();
	}

	static int computeMedian(int[] x, int beginIndex, int endIndex) {
		int size = endIndex - beginIndex + 1;
		if (size % 2 == 0) {
			return (x[beginIndex + size / 2 - 1] + x[beginIndex + size / 2]) / 2;
		} else {
			return x[beginIndex + size / 2];
		}
	}
}
