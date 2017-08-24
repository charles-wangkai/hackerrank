import java.util.Scanner;

public class Solution {
	static final int SIZE = 6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] A = new int[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= SIZE - 2; i++) {
			for (int j = 1; j <= SIZE - 2; j++) {
				result = Math.max(result, A[i - 1][j - 1] + A[i - 1][j] + A[i - 1][j + 1] + A[i][j] + A[i + 1][j - 1]
						+ A[i + 1][j] + A[i + 1][j + 1]);
			}
		}
		System.out.println(result);

		sc.close();
	}
}
