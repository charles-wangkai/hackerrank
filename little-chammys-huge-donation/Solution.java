import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long X = sc.nextLong();
			System.out.println(solve(X));
		}

		sc.close();
	}

	static int solve(long X) {
		int result = -1;

		int lower = 0;
		int upper = 1000000;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;
			long squaresSum = computeSquaresSum(middle);

			if (squaresSum <= X) {
				result = middle;
				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static long computeSquaresSum(int n) {
		return (long) n * (n + 1) * (2 * n + 1) / 6;
	}
}
