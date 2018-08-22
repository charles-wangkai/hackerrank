
// https://en.wikipedia.org/wiki/List_of_trigonometric_identities#Angle_sum_and_difference_identities

import java.util.Scanner;

public class Solution {
	static final int MOD_DIVISOR = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(solve(p, q, n));
		}

		sc.close();
	}

	static int solve(int p, int q, int n) {
		int base = multiplyMod(p, inverseMod(q));

		int result = 0;
		for (int factor = n; factor != 0; factor /= 2) {
			if (factor % 2 != 0) {
				result = computeTangentOfAngleSum(result, base);
			}

			base = computeTangentOfAngleSum(base, base);
		}
		return result;
	}

	static int inverseMod(int x) {
		return powMod(x, MOD_DIVISOR - 2);
	}

	static int computeTangentOfAngleSum(int tanA, int tanB) {
		return multiplyMod(addMod(tanA, tanB), inverseMod(subtractMod(1, multiplyMod(tanA, tanB))));
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}

	static int subtractMod(int x, int y) {
		return (x - y + MOD_DIVISOR) % MOD_DIVISOR;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MOD_DIVISOR);
	}

	static int powMod(int base, int exponent) {
		int result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = multiplyMod(result, base);
			}

			base = multiplyMod(base, base);
			exponent /= 2;
		}
		return result;
	}
}
