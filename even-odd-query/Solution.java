import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N + 1];
		for (int i = 1; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(solve(A, x, y));
		}

		sc.close();
	}

	static String solve(int[] A, int x, int y) {
		int length = y - x + 1;
		if (length >= 2 && A[x + 1] == 0) {
			return display(false);
		} else {
			return display(A[x] % 2 == 0);
		}
	}

	static String display(boolean evenOrOdd) {
		return evenOrOdd ? "Even" : "Odd";
	}
}
