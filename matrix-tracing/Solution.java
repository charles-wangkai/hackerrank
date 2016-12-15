
// https://en.wikipedia.org/wiki/Fermat's_little_theorem

import java.util.Scanner;

public class Solution {
	static final int MODULUS = 1000000007;
	static final int LIMIT = 2000000;

	static int[] factorials;
	static int[] inverseFactorials;

	public static void main(String[] args) {
		buildFactorials();
		buildInverseFactorials();

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(solve(m, n));
		}

		sc.close();
	}

	static int solve(int m, int n) {
		return C(m + n - 2, m - 1);
	}

	static int C(int n, int r) {
		return multiplyMod(multiplyMod(factorials[n], inverseFactorials[r]), inverseFactorials[n - r]);
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}

	static void buildFactorials() {
		factorials = new int[LIMIT];
		factorials[0] = 1;
		int factorial = 1;
		for (int i = 1; i < factorials.length; i++) {
			factorial = multiplyMod(factorial, i);
			factorials[i] = factorial;
		}
	}

	static void buildInverseFactorials() {
		inverseFactorials = new int[LIMIT];
		inverseFactorials[0] = 1;
		int inverseFactorial = 1;
		for (int i = 1; i < factorials.length; i++) {
			inverseFactorial = multiplyMod(inverseFactorial, computeInverse(i));
			inverseFactorials[i] = inverseFactorial;
		}
	}

	static int computeInverse(int n) {
		return powerMod(n, MODULUS - 2);
	}

	static int powerMod(int base, int exponent) {
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
