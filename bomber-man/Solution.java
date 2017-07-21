import java.util.Scanner;

public class Solution {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[][] grid = new int[R][C];
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				grid[r][c] = line.charAt(c) == 'O' ? 3 : 0;
			}
		}

		grid = solve(grid, N);

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(grid[r][c] == 0 ? '.' : 'O');
			}
			System.out.println();
		}

		sc.close();
	}

	static int[][] solve(int[][] grid, int N) {
		int R = grid.length;
		int C = grid[0].length;

		if (N >= 2) {
			N = (N - 2) % 4 + 2;
		}

		boolean plant = false;
		for (int i = 0; i < N; i++) {
			int[][] nextGrid = new int[R][C];

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (plant) {
						if (grid[r][c] > 0) {
							nextGrid[r][c] = grid[r][c] - 1;
						} else {
							nextGrid[r][c] = 3;
						}
					} else {
						if (isDetonate(grid, r, c)) {
							nextGrid[r][c] = 0;
						} else {
							nextGrid[r][c] = Math.max(0, grid[r][c] - 1);
						}
					}
				}
			}

			plant = !plant;
			grid = nextGrid;
		}
		return grid;
	}

	static boolean isDetonate(int[][] grid, int r, int c) {
		int R = grid.length;
		int C = grid[0].length;

		if (grid[r][c] == 1) {
			return true;
		}

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			if (adjR >= 0 && adjR < R && adjC >= 0 && adjC < C && grid[adjR][adjC] == 1) {
				return true;
			}
		}
		return false;
	}
}
