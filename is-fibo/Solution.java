import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long N = sc.nextLong();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static String solve(long N) {
		return isFibonacci(N) ? "IsFibo" : "IsNotFibo";
	}

	static boolean isFibonacci(long N) {
		if (N == 0 || N == 1) {
			return true;
		}

		long prev = 0;
		long curr = 1;
		while (curr < N) {
			long next = prev + curr;

			prev = curr;
			curr = next;
		}
		return curr == N;
	}
}
