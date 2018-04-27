import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int D = sc.nextInt();
			int P = sc.nextInt();
			System.out.println(solve(D, P));
		}

		sc.close();
	}

	static int solve(int D, int P) {
		if (D < 0) {
			return 0;
		}

		if (P == 0) {
			if (D == 0) {
				return 1;
			} else {
				return 4;
			}
		}

		int result = 0;
		for (int a = 1; a * a <= Math.abs(P); a++) {
			if (P % a == 0) {
				int b = Math.abs(P / a);

				result += search(a, b, P, D);
				if (a != b) {
					result += search(b, a, P, D);
				}
			}
		}
		return result;
	}

	static int search(int x, int y, int P, int D) {
		int result = 0;
		if (P > 0) {
			if (check(x, y, D)) {
				result++;
			}
			if (check(-x, -y, D)) {
				result++;
			}
		} else {
			if (check(-x, y, D)) {
				result++;
			}
			if (check(x, -y, D)) {
				result++;
			}
		}
		return result;
	}

	static boolean check(int A, int B, int D) {
		return Math.abs(A - B) == D;
	}
}
