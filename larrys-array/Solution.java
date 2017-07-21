import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			System.out.println(solve(A) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int index = find(A, i + 1);

			while (index >= i + 2) {
				A[index] = A[index - 1];
				A[index - 1] = A[index - 2];
				A[index - 2] = i + 1;

				index -= 2;
			}

			if (index == i + 1) {
				if (index == A.length - 1) {
					return false;
				}

				A[index] = A[index + 1];
				A[index + 1] = A[index - 1];
				A[index - 1] = i + 1;
			}
		}
		return true;
	}

	static int find(int[] a, int target) {
		for (int i = 0;; i++) {
			if (a[i] == target) {
				return i;
			}
		}
	}
}
