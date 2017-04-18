import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] B = new int[N];
		for (int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
		}
		int result = solve(B);
		System.out.println(solve(B) == -1 ? "NO" : result);

		sc.close();
	}

	static int solve(int[] B) {
		int result = 0;
		boolean[] evens = new boolean[B.length];
		for (int i = 0; i < evens.length; i++) {
			evens[i] = B[i] % 2 == 0;
		}

		for (int i = 0; i + 1 < evens.length; i++) {
			if (!evens[i]) {
				evens[i] = !evens[i];
				evens[i + 1] = !evens[i + 1];

				result += 2;
			}
		}

		return evens[evens.length - 1] ? result : -1;
	}
}
