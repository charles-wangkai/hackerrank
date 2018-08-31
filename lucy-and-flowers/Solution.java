import java.util.Scanner;

public class Solution {
	static final int MOD_DIVISOR = 1_000_000_009;
	static final int LIMIT = 5000;

	static int[] modInverses = buildModInverses();
	static int[] bstNums = buildBSTNums();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();

			System.out.println(solve(N));
		}

		sc.close();
	}

	static int solve(int N) {
		int result = 0;
		int comb = 1;
		for (int i = 1; i <= N; i++) {
			comb = divideMod(multiplyMod(comb, N - i + 1), i);

			result = addMod(result, multiplyMod(comb, bstNums[i]));
		}
		return result;
	}

	static int[] buildBSTNums() {
		int[] bstNums = new int[LIMIT + 1];
		bstNums[0] = 1;
		bstNums[1] = 1;
		for (int i = 2; i < bstNums.length; i++) {
			for (int j = 0; j < i; j++) {
				bstNums[i] = addMod(bstNums[i], multiplyMod(bstNums[j], bstNums[i - 1 - j]));
			}
		}
		return bstNums;
	}

	static int[] buildModInverses() {
		modInverses = new int[LIMIT + 1];
		for (int i = 1; i < modInverses.length; i++) {
			modInverses[i] = powMod(i, MOD_DIVISOR - 2);
		}
		return modInverses;
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MOD_DIVISOR);
	}

	static int divideMod(int x, int y) {
		return multiplyMod(x, modInverses[y]);
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
