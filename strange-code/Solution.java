import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long t = sc.nextLong();
		System.out.println(solve(t));

		sc.close();
	}

	static long solve(long t) {
		long limit = 3;
		while (t > limit) {
			t -= limit;
			limit *= 2;
		}
		return limit + 1 - t;
	}
}
