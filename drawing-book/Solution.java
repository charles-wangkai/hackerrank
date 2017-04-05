import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(solve(n, p));

		sc.close();
	}

	static int solve(int n, int p) {
		return Math.min(p / 2, (n / 2 * 2 + 1 - p) / 2);
	}
}
