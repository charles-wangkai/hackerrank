import java.util.Scanner;

public class Solution {
	static final int MOD_DIVISOR = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long S = sc.nextLong();
			System.out.println(solve(S));
		}

		sc.close();
	}

	static long solve(long S) {
		long result = S * 2;
		while (true) {
			long diff = S - (result / 2 - result / 42);

			if (diff == 0) {
				break;
			}

			result += diff * 2;
		}
		return result % MOD_DIVISOR;
	}
}
