import java.util.Scanner;

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
		if (a.length == 1) {
			return a[0] + 1;
		}

		long[] leftGCDs = new long[a.length];
		leftGCDs[0] = a[0];
		for (int i = 1; i < leftGCDs.length; i++) {
			leftGCDs[i] = gcd(leftGCDs[i - 1], a[i]);
		}

		long[] rightGCDs = new long[a.length];
		rightGCDs[rightGCDs.length - 1] = a[rightGCDs.length - 1];
		for (int i = rightGCDs.length - 2; i >= 0; i--) {
			rightGCDs[i] = gcd(rightGCDs[i + 1], a[i]);
		}

		for (int i = 0;; i++) {
			if (i == 0) {
				if (a[i] % rightGCDs[i + 1] != 0) {
					return rightGCDs[i + 1];
				}
			} else if (i == a.length - 1) {
				if (a[i] % leftGCDs[i - 1] != 0) {
					return leftGCDs[i - 1];
				}
			} else {
				long otherGCD = gcd(leftGCDs[i - 1], rightGCDs[i + 1]);
				if (a[i] % otherGCD != 0) {
					return otherGCD;
				}
			}
		}
	}

	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
