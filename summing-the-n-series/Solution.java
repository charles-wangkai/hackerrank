import java.util.Scanner;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long n = sc.nextLong();
			System.out.println(solve(n));
		}

		sc.close();
	}

	static int solve(long n) {
		n %= MODULUS;
		return (int) (n * n % MODULUS);
	}
}
