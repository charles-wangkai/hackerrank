import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(solve(N, M));
		}

		sc.close();
	}

	static int solve(int N, int M) {
		return C(N + M - 1, N).mod(BigInteger.valueOf(MODULUS)).intValue();
	}

	static BigInteger C(int n, int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < m; i++) {
			result = result.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
		}
		return result;
	}
}
