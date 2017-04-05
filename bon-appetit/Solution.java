import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int refund = solve(c, k, b);
		System.out.println(refund == 0 ? "Bon Appetit" : refund);

		sc.close();
	}

	static int solve(int[] c, int k, int b) {
		return b - IntStream.range(0, c.length).filter(i -> i != k).map(i -> c[i]).sum() / 2;
	}
}
