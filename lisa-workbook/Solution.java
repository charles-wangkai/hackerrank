import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t, k));

		sc.close();
	}

	static int solve(int[] t, int k) {
		int special = 0;
		int page = 1;
		int index = 0;
		for (int problemNum : t) {
			for (int i = 1; i <= problemNum; i++) {
				if (i == page) {
					special++;
				}

				index++;
				if (index == k) {
					page++;
					index = 0;
				}
			}

			if (index != 0) {
				page++;
				index = 0;
			}
		}
		return special;
	}
}
