import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c));

		sc.close();
	}

	static int solve(int[] c) {
		Map<Integer, Integer> color2count = new HashMap<Integer, Integer>();
		for (int color : c) {
			if (!color2count.containsKey(color)) {
				color2count.put(color, 0);
			}

			color2count.put(color, color2count.get(color) + 1);
		}

		return color2count.values().stream().mapToInt(count -> count / 2).sum();
	}
}
