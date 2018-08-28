import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static final int MOD_DIVISOR = 1_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(solve(N));

		sc.close();
	}

	static int solve(int N) {
		Map<Integer, Integer> primeFactorToCount = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			merge(primeFactorToCount, factorize(i));
		}

		return primeFactorToCount.values().stream().reduce(1, (result, count) -> multiplyMod(result, count * 2 + 1));
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MOD_DIVISOR);
	}

	static Map<Integer, Integer> factorize(int x) {
		Map<Integer, Integer> primeFactorToCount = new HashMap<>();
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				int count = 0;
				while (x % i == 0) {
					x /= i;
					count++;
				}
				primeFactorToCount.put(i, count);
			}
		}
		if (x != 1) {
			primeFactorToCount.put(x, 1);
		}
		return primeFactorToCount;
	}

	static void merge(Map<Integer, Integer> resultPrimeFactorToCount, Map<Integer, Integer> onePrimeFactorToCount) {
		for (int primeFactor : onePrimeFactorToCount.keySet()) {
			resultPrimeFactorToCount.put(primeFactor,
					resultPrimeFactorToCount.getOrDefault(primeFactor, 0) + onePrimeFactorToCount.get(primeFactor));
		}
	}
}
