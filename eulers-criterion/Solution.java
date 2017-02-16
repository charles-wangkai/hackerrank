import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int M = sc.nextInt();

			System.out.println(solve(A, M) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int A, int M) {
		if (M == 2 || A == 0) {
			return true;
		}

		return powMod(A, (M - 1) / 2, M) == 1;
	}

	static int powMod(int base, int exponent, int modulus) {
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

	static int multiplyMod(int x, int y, int modulus) {
		return (int) ((long) x * y % modulus);
	}
}
