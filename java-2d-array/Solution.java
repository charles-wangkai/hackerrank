import java.util.Scanner;

public class Solution {
	static final int SIZE = 6;
	static final int[] OFFSET_R = { -1, -1, -1, 0, 1, 1, 1 };
	static final int[] OFFSET_C = { -1, 0, 1, 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] board = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = in.nextInt();
			}
		}
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i < SIZE - 1; i++) {
			for (int j = 1; j < SIZE - 1; j++) {
				maxSum = Math.max(maxSum, computeHourglassesSum(board, i, j));
			}
		}
		System.out.println(maxSum);
		in.close();
	}

	static int computeHourglassesSum(int[][] board, int r, int c) {
		int sum = 0;
		for (int i = 0; i < OFFSET_R.length; i++) {
			sum += board[r + OFFSET_R[i]][c + OFFSET_C[i]];
		}
		return sum;
	}
}
