import java.util.Scanner;

public class Solution {
	static final int SIZE = 3;

	static int minCost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] s = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(int[][] s) {
		minCost = Integer.MAX_VALUE;

		int[] numbers = new int[SIZE * SIZE];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		search(new int[SIZE][SIZE], numbers, 0, 0, s);

		return minCost;
	}

	static void search(int[][] matrix, int[] numbers, int row, int col, int[][] s) {
		if (row == SIZE) {
			if (isMagic(matrix)) {
				int cost = 0;
				for (int r = 0; r < SIZE; r++) {
					for (int c = 0; c < SIZE; c++) {
						cost += Math.abs(matrix[r][c] - s[r][c]);
					}
				}
				minCost = Math.min(minCost, cost);
			}

			return;
		}

		if (col == SIZE) {
			search(matrix, numbers, row + 1, 0, s);

			return;
		}

		int index = row * SIZE + col;
		for (int i = index; i < numbers.length; i++) {
			swap(numbers, index, i);
			matrix[row][col] = numbers[index];
			search(matrix, numbers, row, col + 1, s);
			swap(numbers, index, i);
		}
	}

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	static boolean isMagic(int[][] matrix) {
		final int SUM = 15;
		return matrix[0][0] + matrix[0][1] + matrix[0][2] == SUM && matrix[1][0] + matrix[1][1] + matrix[1][2] == SUM
				&& matrix[2][0] + matrix[2][1] + matrix[2][2] == SUM
				&& matrix[0][0] + matrix[1][0] + matrix[2][0] == SUM
				&& matrix[0][1] + matrix[1][1] + matrix[2][1] == SUM
				&& matrix[0][2] + matrix[1][2] + matrix[2][2] == SUM
				&& matrix[0][0] + matrix[1][1] + matrix[2][2] == SUM
				&& matrix[0][2] + matrix[1][1] + matrix[2][0] == SUM;
	}
}
