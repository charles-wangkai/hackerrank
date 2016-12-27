import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		int g = a[0];
		for (int i = 1; i < a.length; i++) {
			g = gcd(g, a[i]);
		}
		return g == 1;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
