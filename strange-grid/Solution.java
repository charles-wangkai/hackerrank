import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(r, c));

		sc.close();
	}

	static long solve(int r, int c) {
		return (r - 1) / 2 * 10L + (r % 2 == 0 ? 1 : 0) + (c - 1) * 2;
	}
}
