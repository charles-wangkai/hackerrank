import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static long[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] coins = new int[m];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = sc.nextInt();
		}

		cache = new long[n + 1][m];
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}

		Arrays.sort(coins);
		System.out.println(solve(coins, n, coins.length - 1));

		sc.close();
	}

	static long solve(int[] coins, int remain, int index) {
		if (remain == 0) {
			return 1;
		}

		if (index == 0) {
			return remain % coins[0] == 0 ? 1 : 0;
		}

		if (cache[remain][index] >= 0) {
			return cache[remain][index];
		}

		long result = 0;
		for (int i = 0; i * coins[index] <= remain; i++) {
			result += solve(coins, remain - i * coins[index], index - 1);
		}
		cache[remain][index] = result;
		return result;
	}
}
