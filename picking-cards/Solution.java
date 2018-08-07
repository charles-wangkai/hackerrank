import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] c = new int[N];
			for (int i = 0; i < c.length; i++) {
				c[i] = sc.nextInt();
			}

			System.out.println(solve(c));
		}

		sc.close();
	}

	static int solve(int[] c) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : c) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int result = 1;
		int card = 0;
		for (int i = 0; i < c.length; i++) {
			card += valueToCount.getOrDefault(i, 0);

			if (card == 0) {
				return 0;
			}

			result = multiplyMod(result, card);

			card--;
		}
		return result;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MOD_DIVISOR);
	}
}
