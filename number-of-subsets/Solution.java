
// http://oeis.org/A000325
// https://en.wikipedia.org/wiki/Fermat%27s_little_theorem

import java.util.Scanner;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long N = sc.nextLong();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static int solve(long N) {
		return powMod(2, addMod(powMod(2, N, MODULUS - 1), (int) (-N % (MODULUS - 1)), MODULUS - 1), MODULUS);
	}

	static int powMod(int base, long exponent, int m) {
		int result = 1;
		while (exponent != 0) {
			if ((exponent & 1) != 0) {
				result = multiplyMod(result, base, m);
			}

			base = multiplyMod(base, base, m);
			exponent >>= 1;
		}
		return result;
	}

	static int multiplyMod(int x, int y, int m) {
		return (int) ((long) x * y % m);
	}

	static int addMod(int x, int y, int m) {
		return (int) (((long) x + y + m) % m);
	}
}
