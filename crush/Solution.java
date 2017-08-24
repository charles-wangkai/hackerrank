import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		long[] deltas = new long[n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();

			deltas[a - 1] += k;
			if (b < deltas.length) {
				deltas[b] -= k;
			}
		}

		long maxNumber = Long.MIN_VALUE;
		long number = 0;
		for (int i = 0; i < deltas.length; i++) {
			number += deltas[i];
			maxNumber = Math.max(maxNumber, number);
		}
		System.out.println(maxNumber);

		sc.close();
	}
}
