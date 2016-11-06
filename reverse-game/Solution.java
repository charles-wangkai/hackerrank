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
		int left = 0;
		int right = N - 1;
		boolean leftOrRight = false;
		for (int i = 0;; i++) {
			int ball;
			if (leftOrRight) {
				ball = left;
				left++;
			} else {
				ball = right;
				right--;
			}

			if (ball == K) {
				return i;
			}

			leftOrRight = !leftOrRight;
		}
	}
}
