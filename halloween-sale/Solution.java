import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int d = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();

		System.out.println(solve(p, d, m, s));

		sc.close();
	}

	static int solve(int p, int d, int m, int s) {
		int price = p;
		int result = 0;
		while (s >= price) {
			s -= price;
			result++;

			price = Math.max(m, price - d);
		}
		return result;
	}
}
