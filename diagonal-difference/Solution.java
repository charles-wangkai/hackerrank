import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		System.out.println(Math.abs(computeSum(matrix, 0, 0, 1, 1, N)
				- computeSum(matrix, 0, N - 1, 1, -1, N)));

		in.close();
	}

	static int computeSum(int[][] matrix, int r, int c, int offsetR,
			int offsetC, int step) {
		int sum = 0;
		for (int i = 0; i < step; i++) {
			sum += matrix[r + offsetR * i][c + offsetC * i];
		}
		return sum;
	}
}
