import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long n = sc.nextLong();
			System.out.println(solve(n));
		}

		sc.close();
	}

	static long solve(long n) {
		long result = -1;
		long lower = 0;
		long upper = 100000000000000000L;
		while (lower <= upper) {
			long middle = (lower + upper) / 2;

			if (computeTrailingZeroNum(middle) >= n) {
				result = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
		return result;
	}

	static long computeTrailingZeroNum(long m) {
		if (m == 0) {
			return 0;
		}

		return m / 5 + computeTrailingZeroNum(m / 5);
	}
}
