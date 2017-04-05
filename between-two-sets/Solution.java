import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] A = readArray(sc, n);
		int[] B = readArray(sc, m);
		System.out.println(solve(A, B));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] A, int[] B) {
		int g = gcd(B);

		if (!Arrays.stream(A).allMatch(a -> g % a == 0)) {
			return 0;
		}

		return computeDivisorNum(g / lcm(A));
	}

	static int gcd(int[] x) {
		int g = x[0];
		for (int i = 1; i < x.length; i++) {
			g = gcd(g, x[i]);
		}
		return g;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

	static int lcm(int[] x) {
		int l = x[0];
		for (int i = 1; i < x.length; i++) {
			l = lcm(l, x[i]);
		}
		return l;
	}

	static int lcm(int x, int y) {
		return x * y / gcd(x, y);
	}

	static int computeDivisorNum(int x) {
		int divisorNum = 1;
		int prime = 2;
		while (x != 1) {
			while (!isPrime(prime)) {
				prime++;
			}

			int exponent = 0;
			while (x % prime == 0) {
				x /= prime;
				exponent++;
			}
			divisorNum *= exponent + 1;

			prime++;
		}
		return divisorNum;
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
