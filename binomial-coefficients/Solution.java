
// https://en.wikipedia.org/wiki/Lucas%27s_theorem

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			BigInteger n = sc.nextBigInteger();
			int P = sc.nextInt();

			System.out.println(solve(n, P));
		}

		sc.close();
	}

	static BigInteger solve(BigInteger n, int P) {
		BigInteger nonZeroModNum = BigInteger.ONE;
		for (BigInteger i = n; !i.equals(BigInteger.ZERO); i = i.divide(BigInteger.valueOf(P))) {
			nonZeroModNum = nonZeroModNum.multiply(i.mod(BigInteger.valueOf(P)).add(BigInteger.ONE));
		}
		return n.add(BigInteger.ONE).subtract(nonZeroModNum);
	}
}
