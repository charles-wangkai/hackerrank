import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final int LIMIT_D = 19;
	static final int LIMIT_S = 300000;

	static long[][] f;
	static long[] c;

	public static void main(String[] args) {
		buildF();
		buildC();

		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long x = sc.nextLong();

			System.out.println(solve(x));
		}

		sc.close();
	}

	static BigInteger solve(long x) {
		int s = findS(x);
		long g = x - (s == 0 ? 0 : c[s - 1]);

		StringBuilder result = new StringBuilder();
		for (int d = LIMIT_D; d >= 1; d--) {
			int j = -1;
			long prevNumberCount = -1;
			long numberCount = 0;
			while (numberCount < g) {
				j++;

				prevNumberCount = numberCount;
				numberCount += f[d - 1][s - j * (1 << (d - 1))];
			}

			result.append(j);
			s -= j * (1 << (d - 1));
			g -= prevNumberCount;
		}
		return new BigInteger(result.toString());
	}

	static int findS(long x) {
		int index = Arrays.binarySearch(c, x);
		if (index < 0) {
			index = -1 - index;
		}
		return index;
	}

	static void buildF() {
		f = new long[LIMIT_D + 1][LIMIT_S + 1];
		for (int d = 0; d <= LIMIT_D; d++) {
			for (int s = 0; s <= LIMIT_S; s++) {
				if (d == 0) {
					if (s == 0) {
						f[d][s] = 1;
					} else {
						f[d][s] = 0;
					}
				} else {
					f[d][s] = 0;
					for (int i = 0; i <= 9; i++) {
						long nextS = s - i * (1L << (d - 1));
						if (nextS >= 0) {
							f[d][s] += f[d - 1][(int) nextS];
						}
					}
				}
			}
		}
	}

	static void buildC() {
		c = new long[LIMIT_S + 1];
		long sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += f[LIMIT_D][i];
			c[i] = sum;
		}
	}
}
