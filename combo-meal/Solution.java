import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int b = sc.nextInt();
			int s = sc.nextInt();
			int c = sc.nextInt();

			System.out.println(solve(b, s, c));
		}

		sc.close();
	}

	static int solve(int b, int s, int c) {
		return b + s - c;
	}
}
