import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long m = sc.nextLong();
		long w = sc.nextLong();
		long p = sc.nextLong();
		long n = sc.nextLong();
		System.out.println(solve(m, w, p, n));

		sc.close();
	}

	static long solve(long m, long w, long p, long n) {
		if (BigInteger.valueOf(m).multiply(BigInteger.valueOf(w)).compareTo(BigInteger.valueOf(n)) > 0) {
			return 1;
		}

		long minPass = Long.MAX_VALUE;
		long currentPass = 0;
		long production = 0;
		while (true) {
			long remainPass = divideToCeil(n - production, m * w);
			minPass = Math.min(minPass, currentPass + remainPass);

			if (remainPass == 1) {
				break;
			}

			if (production < p) {
				long extraPass = divideToCeil(p - production, m * w);

				currentPass += extraPass;
				production += extraPass * m * w;

				if (production >= n) {
					minPass = Math.min(minPass, currentPass);

					break;
				}
			}

			production -= p;
			if (m <= w) {
				m++;
			} else {
				w++;
			}
		}
		return minPass;
	}

	static long divideToCeil(long x, long y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
