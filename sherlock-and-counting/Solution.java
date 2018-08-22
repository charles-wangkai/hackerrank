import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			System.out.println(solve(n, k));
		}

		sc.close();
	}

	static int solve(int n, int k) {
		long a = 1;
		long b = -n;
		long c = (long) n * k;

		long discriminant = b * b - 4 * a * c;

		if (discriminant <= 0) {
			return n - 1;
		}

		int exclusionLower = (int) Math.floor((-b - Math.sqrt(discriminant)) / (2 * a));
		while (isTooFar(a, b, discriminant, exclusionLower)) {
			exclusionLower++;
		}

		int exclusionUpper = (int) Math.ceil((-b + Math.sqrt(discriminant)) / (2 * a));
		while (isTooFar(a, b, discriminant, exclusionUpper)) {
			exclusionUpper--;
		}

		return (n - 1) - (exclusionUpper - exclusionLower + 1);
	}

	static long square(long x) {
		return x * x;
	}

	static boolean isTooFar(long a, long b, long discriminant, int x) {
		return square((long) x * 2 * a + b) >= discriminant;
	}
}
