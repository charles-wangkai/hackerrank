
// https://en.wikipedia.org/wiki/Lucas%27s_theorem
// https://en.wikipedia.org/wiki/Chinese_remainder_theorem

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			int M = sc.nextInt();

			System.out.println(solve(N, R, M));
		}

		sc.close();
	}

	static int solve(int N, int R, int M) {
		List<Integer> primeFactors = computePrimeFactorsForSquareFree(M);

		Map<Integer, Integer> primeFactorToRemainder = new HashMap<>();
		for (int primeFactor : primeFactors) {
			int remainder = computeRemainder(N, R, primeFactor);

			primeFactorToRemainder.put(primeFactor, remainder);
		}

		return computeOverallRemainder(M, primeFactorToRemainder);
	}

	static List<Integer> computePrimeFactorsForSquareFree(int x) {
		List<Integer> primeFactors = new ArrayList<>();
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				primeFactors.add(i);
				x /= i;
			}
		}
		if (x != 1) {
			primeFactors.add(x);
		}
		return primeFactors;
	}

	static int addMod(int x, int y, int modDivisor) {
		return (x + y) % modDivisor;
	}

	static int multiplyMod(int x, int y, int modDivisor) {
		return (int) ((long) x * y % modDivisor);
	}

	static int powMod(int base, int exponent, int modDivisor) {
		int result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = multiplyMod(result, base, modDivisor);
			}

			base = multiplyMod(base, base, modDivisor);
			exponent /= 2;
		}
		return result;
	}

	static int modInverse(int x, int modDivisor) {
		return powMod(x, modDivisor - 2, modDivisor);
	}

	static int C(int m, int n, int modDivisor) {
		long combination = 1;
		for (int i = 0; i < n; i++) {
			combination = combination * (m - i) / (i + 1);
		}
		return (int) (combination % modDivisor);
	}

	static int computeRemainder(int m, int n, int p) {
		int result = 1;
		while (m != 0 || n != 0) {
			result = multiplyMod(result, C(m % p, n % p, p), p);

			m /= p;
			n /= p;
		}
		return result;
	}

	static int computeOverallRemainder(int M, Map<Integer, Integer> primeFactorToRemainder) {
		int result = 0;
		for (int primeFactor : primeFactorToRemainder.keySet()) {
			int remainder = primeFactorToRemainder.get(primeFactor);
			int Mi = M / primeFactor;

			result = addMod(result, multiplyMod(multiplyMod(remainder, modInverse(Mi, primeFactor), M), Mi, M), M);
		}
		return result;
	}
}
