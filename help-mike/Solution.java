import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			System.out.println(solve(N, K));
		}

		sc.close();
	}

	static long solve(int N, int K) {
		int[] counts = new int[K];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = N / K;
		}

		int index = 1;
		for (int i = 0; i < N % K; i++) {
			counts[index]++;
			index = (index + 1) % counts.length;
		}

		long result = C(counts[0], 2);
		for (int i = 1; i * 2 < counts.length; i++) {
			result += (long) counts[i] * counts[K - i];
		}
		if (counts.length % 2 == 0) {
			result += C(counts[K / 2], 2);
		}
		return result;
	}

	static long C(int n, int m) {
		long result = 1;
		for (int i = 0; i < m; i++) {
			result = result * (n - i) / (i + 1);
		}
		return result;
	}
}
