import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println(solve(A, k));

		sc.close();
	}

	static int solve(int[] A, int k) {
		int g = A[0];
		for (int i = 1; i < A.length; i++) {
			g = gcd(g, A[i]);
		}

		int minFactor = computeMinFactor(g);

		return k / minFactor * minFactor;
	}

	static int computeMinFactor(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return i;
			}
		}
		return n;
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
