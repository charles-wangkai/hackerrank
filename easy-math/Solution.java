import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int X = sc.nextInt();

			System.out.println(solve(X));
		}

		sc.close();
	}

	static int solve(int X) {
		int exponent2 = 0;
		while (X % 2 == 0) {
			exponent2++;
			X /= 2;
		}

		int exponent5 = 0;
		while (X % 5 == 0) {
			exponent5++;
			X /= 5;
		}

		int b = Math.max(exponent2 - 2, exponent5);

		int a = 1;
		int remainder = 1 % X;
		while (remainder != 0) {
			a++;
			remainder = (remainder * 10 + 1) % X;
		}

		return 2 * a + b;
	}
}
