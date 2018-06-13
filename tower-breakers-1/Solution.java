import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println(solve(n, m));
		}

		sc.close();
	}

	static int solve(int n, int m) {
		return (n % 2 == 1 && m != 1) ? 1 : 2;
	}
}
