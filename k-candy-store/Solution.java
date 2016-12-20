import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	static final int MODOLUS = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			System.out.println(solve(N, K));
		}

		sc.close();
	}

	static int solve(int N, int K) {
		return C(K + N - 1, N - 1).mod(BigInteger.valueOf(MODOLUS)).intValue();
	}

	static BigInteger C(int n, int r) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= r; i++) {
			result = result.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
		}
		return result;
	}
}
