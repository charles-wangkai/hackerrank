import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}

		System.out.println(solve(c, k));

		sc.close();
	}

	static int solve(int[] c, int k) {
		Arrays.sort(c);

		int result = 0;
		int customer = 0;
		int prevPurchase = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			result += c[i] * (prevPurchase + 1);

			customer++;
			if (customer == k) {
				customer = 0;
				prevPurchase++;
			}
		}
		return result;
	}
}
