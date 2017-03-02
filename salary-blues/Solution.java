import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();

		long[] A = new long[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextLong();
		}

		long diffsGCD = computeDiffsGCD(A);

		for (int tc = 0; tc < Q; tc++) {
			int K = sc.nextInt();
			System.out.println(gcd(diffsGCD, A[0] + K));
		}

		sc.close();
	}

	static long computeDiffsGCD(long[] A) {
		long diffsGCD = Math.abs(A[1] - A[0]);
		for (int i = 2; i < A.length; i++) {
			diffsGCD = gcd(diffsGCD, Math.abs(A[i] - A[i - 1]));
		}
		return diffsGCD;
	}

	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
