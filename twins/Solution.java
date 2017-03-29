import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		int size = m - n + 1;
		List<Integer> primeDivisors = sievePrimes(size);

		boolean[] primes = new boolean[size];
		Arrays.fill(primes, true);

		for (int primeDivisor : primeDivisors) {
			for (int i = n / primeDivisor * primeDivisor; i <= m; i += primeDivisor) {
				if (i >= n && i > primeDivisor) {
					primes[i - n] = false;
				}
			}
		}

		int result = 0;
		for (int i = 0; i + 2 < primes.length; i++) {
			if (n + i >= 2 && primes[i] && primes[i + 2]) {
				result++;
			}
		}
		return result;
	}

	static List<Integer> sievePrimes(int limit) {
		boolean[] primes = new boolean[limit + 1];
		Arrays.fill(primes, true);

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				result.add(i);

				for (long j = (long) i * i; j < primes.length; j += i) {
					primes[(int) j] = false;
				}
			}
		}
		return result;
	}
}
