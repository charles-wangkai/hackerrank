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

	static int solve(int N, int K) {
		int result = -1;
		for (int a = 1; a <= N; a++) {
			for (int b = a + 1; b <= N; b++) {
				if ((a & b) < K) {
					result = Math.max(result, a & b);
				}
			}
		}
		return result;
	}
}
