import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final int LIMIT = 1000000;

	static int[] properDivisorNums;
	static int[] evenPerfectSquareProperDivisorNums;

	public static void main(String[] args) {
		buildProperDivisorNums();
		buildEvenPerfectSquareProperDivisorNums();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}
		sc.close();
	}

	static String solve(int N) {
		if (evenPerfectSquareProperDivisorNums[N] == 0) {
			return "0";
		} else {
			int g = gcd(evenPerfectSquareProperDivisorNums[N], properDivisorNums[N]);
			return String.format("%d/%d", evenPerfectSquareProperDivisorNums[N] / g, properDivisorNums[N] / g);
		}
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	static void buildProperDivisorNums() {
		properDivisorNums = new int[LIMIT + 1];
		Arrays.fill(properDivisorNums, 1);

		boolean[] primes = new boolean[properDivisorNums.length];
		Arrays.fill(primes, true);

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (long j = (long) i * i; j < primes.length; j += i) {
					primes[(int) j] = false;
				}

				long base = i;
				for (int exponent = 1; base < properDivisorNums.length; exponent++) {
					for (int j = 1; base * j < properDivisorNums.length; j++) {
						if (j % i != 0) {
							properDivisorNums[(int) (base * j)] *= exponent + 1;
						}
					}

					base *= i;
				}
			}
		}

		for (int i = 0; i < properDivisorNums.length; i++) {
			properDivisorNums[i]--;
		}
	}

	static void buildEvenPerfectSquareProperDivisorNums() {
		evenPerfectSquareProperDivisorNums = new int[properDivisorNums.length];

		for (int i = 2; (long) i * i < evenPerfectSquareProperDivisorNums.length; i += 2) {
			int square = i * i;
			for (int j = square * 2; j < evenPerfectSquareProperDivisorNums.length; j += square) {
				evenPerfectSquareProperDivisorNums[j]++;
			}
		}
	}
}
