import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		for (int tc = 0; tc < s; tc++) {
			int n = sc.nextInt();
			System.out.println(solve(n));
		}

		sc.close();
	}

	static int solve(int n) {
		int prevprevprev = 0;
		int prevprev = 1;
		int prev = 1;
		for (int i = 0; i < n - 1; i++) {
			int current = prevprevprev + prevprev + prev;
			prevprevprev = prevprev;
			prevprev = prev;
			prev = current;
		}
		return prev;
	}
}
