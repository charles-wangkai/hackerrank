import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long N = sc.nextLong();
			int M = sc.nextInt();
			System.out.println(solve(N, M));
		}

		sc.close();
	}

	static int solve(long N, int M) {
		if (N == 1) {
			return 1 % M;
		}

		if (N % 2 != 0) {
			return addMod(multiplyMod(solve(N - 1, M), 10, M), 1, M);
		} else {
			int subResult = solve(N / 2, M);
			return addMod(multiplyMod(subResult, powMod(10, N / 2, M), M), subResult, M);
		}
	}

	static int multiplyMod(int x, int y, int modulus) {
		return (int) ((long) x * y % modulus);
	}

	static int addMod(int x, int y, int modulus) {
		return (x + y) % modulus;
	}

	static int powMod(int base, long exponent, int modulus) {
		int result = 1;
		while (exponent != 0) {
			if ((exponent & 1) != 0) {
				result = multiplyMod(result, base, modulus);
			}

			base = multiplyMod(base, base, modulus);
			exponent >>= 1;
		}
		return result;
	}
}
