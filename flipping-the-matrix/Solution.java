import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();

			int[][] matrix = new int[n * 2][n * 2];
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[0].length; c++) {
					matrix[r][c] = sc.nextInt();
				}
			}

			System.out.println(solve(matrix));
		}

		sc.close();
	}

	static int solve(int[][] matrix) {
		int size = matrix.length;
		int n = size / 2;

		int result = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				result += Math.max(Math.max(matrix[r][c], matrix[size - 1 - r][c]),
						Math.max(matrix[r][size - 1 - c], matrix[size - 1 - r][size - 1 - c]));
			}
		}
		return result;
	}
}
