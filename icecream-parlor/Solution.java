import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] costs = new int[n];
			for (int i = 0; i < costs.length; i++) {
				costs[i] = sc.nextInt();
			}

			int[] indexes = solve(m, costs);
			System.out.println(indexes[0] + " " + indexes[1]);
		}

		sc.close();
	}

	static int[] solve(int m, int[] costs) {
		for (int i = 0;; i++) {
			for (int j = i + 1; j < costs.length; j++) {
				if (costs[i] + costs[j] == m) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
	}
}
