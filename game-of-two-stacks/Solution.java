import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int g = sc.nextInt();
		for (int tc = 0; tc < g; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int x = sc.nextInt();
			int[] a = readArray(sc, n);
			int[] b = readArray(sc, m);

			System.out.println(solve(a, b, x));
		}

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b, int x) {
		int lengthB = 0;
		int sum = 0;
		while (lengthB < b.length && sum + b[lengthB] <= x) {
			sum += b[lengthB];
			lengthB++;
		}

		int maxScore = lengthB;
		for (int lengthA = 1; lengthA <= a.length; lengthA++) {
			sum += a[lengthA - 1];

			while (sum > x && lengthB > 0) {
				lengthB--;
				sum -= b[lengthB];
			}

			if (sum > x) {
				break;
			}

			maxScore = Math.max(maxScore, lengthA + lengthB);
		}
		return maxScore;
	}
}
