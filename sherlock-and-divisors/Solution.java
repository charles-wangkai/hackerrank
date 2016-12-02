import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static int solve(int N) {
		int result = 0;
		for (int i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				if (i % 2 == 0) {
					result++;
				}
				if (N / i != i && N / i % 2 == 0) {
					result++;
				}
			}
		}
		return result;
	}
}
