import java.util.Scanner;

public class Solution {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] heights = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				heights[i][j] = sc.nextInt();
			}
		}

		System.out.println(solve(heights));

		sc.close();
	}

	static int solve(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;

		int surface = row * col * 2;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				for (int i = 0; i < R_OFFSETS.length; i++) {
					int adjR = r + R_OFFSETS[i];
					int adjC = c + C_OFFSETS[i];

					int adjHeight = (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col) ? heights[adjR][adjC] : 0;
					surface += Math.max(0, heights[r][c] - adjHeight);
				}
			}
		}
		return surface;
	}
}
