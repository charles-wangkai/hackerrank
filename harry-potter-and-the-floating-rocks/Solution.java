import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(solve(x1, y1, x2, y2));
		}

		sc.close();
	}

	static int solve(int x1, int y1, int x2, int y2) {
		return gcd(Math.abs(x1 - x2), Math.abs(y1 - y2)) - 1;
	}

	static int gcd(int a, int b) {
		return (b == 0) ? Math.max(1, a) : gcd(b, a % b);
	}
}
