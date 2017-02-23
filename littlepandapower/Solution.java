import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int X = sc.nextInt();

			System.out.println(solve(A, B, X));
		}

		sc.close();
	}

	static int solve(int A, int B, int X) {
		if (B >= 0) {
			return powMod(A, B, X);
		} else {
			return powMod(inverseMod(A, X), -B, X);
		}
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

	static int inverseMod(int x, int modulus) {
		return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
	}
}
