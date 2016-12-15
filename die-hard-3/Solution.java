import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			System.out.println(solve(a, b, c));
		}

		sc.close();
	}

	static String solve(int a, int b, int c) {
		return (c <= Math.max(a, b) && c % gcd(a, b) == 0) ? "YES" : "NO";
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
