import java.util.Scanner;

public class Solution {
	static final int MODULUS = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static int solve(int N) {
		int result = 1;
		for (int i = 0; i < N; i++) {
			result = result * 2 % MODULUS;
		}
		result = (result - 1 + MODULUS) % MODULUS;
		return result;
	}
}
