import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();

			System.out.println(solve(a, b, x));
		}

		sc.close();
	}

	static int solve(int a, int b, int x) {
		if (a == 1 || b == 0) {
			return getCloser(1, 0, x);
		}

		if (b < 0) {
			return 0;
		}

		int target = 1;
		for (int i = 0; i < b; i++) {
			target *= a;
		}
		return getCloser(target, target / x * x, (target / x + 1) * x);
	}

	static int getCloser(int target, int n1, int n2) {
		return (Math.abs(n1 - target) <= Math.abs(n2 - target)) ? n1 : n2;
	}
}
