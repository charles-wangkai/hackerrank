import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int l = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(l, b));
		}
		sc.close();
	}

	static int solve(int l, int b) {
		int g = gcd(l, b);
		return l * b / g / g;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
