import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static long solve(long[] a) {
		return Arrays.stream(a).map(Solution::computeMaxSequenceLength).sum();
	}

	static long computeMaxSequenceLength(long stickLength) {
		long result = 0;
		long stickCount = 1;
		SortedMap<Long, Integer> primeFactorToCount = buildPrimeFactorToCount(stickLength);
		while (!primeFactorToCount.isEmpty()) {
			long maxPrimeFactor = primeFactorToCount.lastKey();

			result += stickCount;
			stickCount *= maxPrimeFactor;

			primeFactorToCount.put(maxPrimeFactor, primeFactorToCount.get(maxPrimeFactor) - 1);
			if (primeFactorToCount.get(maxPrimeFactor) == 0) {
				primeFactorToCount.remove(maxPrimeFactor);
			}
		}
		result += stickCount;
		return result;
	}

	static SortedMap<Long, Integer> buildPrimeFactorToCount(long stickLength) {
		SortedMap<Long, Integer> primeFactorToCount = new TreeMap<>();
		for (int i = 2; (long) i * i <= stickLength; i++) {
			if (stickLength % i == 0) {
				int count = 0;
				while (stickLength % i == 0) {
					count++;
					stickLength /= i;
				}

				primeFactorToCount.put((long) i, count);
			}
		}
		if (stickLength != 1) {
			primeFactorToCount.put(stickLength, 1);
		}
		return primeFactorToCount;
	}
}
