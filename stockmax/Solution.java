import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] prices = new int[N];
			for (int i = 0; i < prices.length; i++) {
				prices[i] = sc.nextInt();
			}

			System.out.println(solve(prices));
		}

		sc.close();
	}

	static long solve(int[] prices) {
		long profit = 0;
		int highIndex = prices.length - 1;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > prices[highIndex]) {
				highIndex = i;
			} else {
				profit += prices[highIndex] - prices[i];
			}
		}
		return profit;
	}
}
