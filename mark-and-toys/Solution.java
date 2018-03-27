import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}

		System.out.println(solve(prices, k));

		sc.close();
	}

	static int solve(int[] prices, int k) {
		Arrays.sort(prices);

		for (int i = 0, sum = 0;; sum += prices[i], i++) {
			if (sum > k) {
				return i - 1;
			} else if (i == prices.length) {
				return i;
			}
		}
	}
}
