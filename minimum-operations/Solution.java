import java.util.Scanner;
import java.util.Vector;

class MinimumOperations {
	private static final Scanner scan = new Scanner(System.in);
	int n, r, g, b;
	int[][] dp = new int[110][1 << 3];

	Vector<Integer> red = new Vector<Integer>();
	Vector<Integer> green = new Vector<Integer>();
	Vector<Integer> blue = new Vector<Integer>();

	public void get() {
		n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			r = scan.nextInt();
			g = scan.nextInt();
			b = scan.nextInt();
			red.add(r);
			green.add(g);
			blue.add(b);
		}
	}

	public void minOperations() {
		int i, j;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= 7; j++) {
				dp[i][j] = (1 << 30);
			}
		}
		dp[0][0] = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j <= 7; j++) {
				dp[i + 1][j | 1] = Math.min(dp[i + 1][j | 1], dp[i][j] + green.get(i) + blue.get(i));
				dp[i + 1][j | 2] = Math.min(dp[i + 1][j | 2], dp[i][j] + red.get(i) + blue.get(i));
				dp[i + 1][j | 4] = Math.min(dp[i + 1][j | 4], dp[i][j] + red.get(i) + green.get(i));
			}
		}
		j = 0;
		for (i = 0; i < n; i++) {
			if (red.get(i) != 0)
				j |= 1;
			if (green.get(i) != 0)
				j |= 2;
			if (blue.get(i) != 0)
				j |= 4;
		}
		if (dp[n][j] >= (1 << 30))
			dp[n][j] = -1;
		System.out.println(dp[n][j]);
	}
}

class Solution {
	public static void main(String[] args) {
		MinimumOperations obj = new MinimumOperations();
		obj.get();
		obj.minOperations();
	}
}
