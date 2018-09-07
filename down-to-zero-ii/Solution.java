import java.util.Scanner;

public class Solution {
	static final int LIMIT = 1_000_000;
	static int[] solutions = buildSolutions();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();
		for (int tc = 0; tc < Q; tc++) {
			int N = sc.nextInt();

			System.out.println(solve(N));
		}

		sc.close();
	}

	static int[] buildSolutions() {
		int[] solutions = new int[LIMIT + 1];
		for (int i = 1; i < solutions.length; i++) {
			solutions[i] = solutions[i - 1] + 1;

			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					solutions[i] = Math.min(solutions[i], solutions[i / j] + 1);
				}
			}
		}
		return solutions;
	}

	static int solve(int N) {
		return solutions[N];
	}
}
