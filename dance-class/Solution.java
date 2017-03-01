import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long i = sc.nextLong();
			System.out.println(solve(i));
		}

		sc.close();
	}

	static String solve(long i) {
		return (computeSquareRoot(i) % 2 == 0) ? "even" : "odd";
	}

	static int computeSquareRoot(long n) {
		int squareRoot = (int) Math.sqrt(n);
		while (square(squareRoot) <= n) {
			squareRoot++;
		}
		while (square(squareRoot) > n) {
			squareRoot--;
		}
		return squareRoot;
	}

	static long square(int n) {
		return (long) n * n;
	}
}
