import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int K = sc.nextInt();
			System.out.println(solve(K));
		}

		sc.close();
	}

	static long solve(int K) {
		return (long) (K / 2) * (K - K / 2);
	}
}
