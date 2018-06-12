import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long n = sc.nextLong();
			System.out.println(solve(n));
		}

		sc.close();
	}

	static long solve(long n) {
		return ~n & ((1L << 32) - 1);
	}
}
