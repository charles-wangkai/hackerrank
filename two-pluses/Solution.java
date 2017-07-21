import java.util.Scanner;

public class Solution {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	static int maxProduct;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[][] cells = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				cells[i][j] = line.charAt(j) == 'G';
			}
		}
		System.out.println(solve(cells));

		sc.close();
	}

	static int solve(boolean[][] cells) {
		maxProduct = 0;

		search(cells, new int[2], 0);

		return maxProduct;
	}

	static void search(boolean[][] cells, int[] sizes, int index) {
		if (index == sizes.length) {
			maxProduct = Math.max(maxProduct, (4 * sizes[0] + 1) * (4 * sizes[1] + 1));
			return;
		}

		int row = cells.length;
		int col = cells[0].length;

		for (int size = (index == 0) ? Math.min((cells.length - 1) / 2, (cells[0].length - 1) / 2)
				: sizes[index - 1]; size >= 0; size--) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (canFill(cells, r, c, size)) {
						fill(cells, r, c, size, false);
						sizes[index] = size;

						search(cells, sizes, index + 1);

						fill(cells, r, c, size, true);
					}
				}
			}
		}
	}

	static void fill(boolean[][] cells, int r, int c, int size, boolean value) {
		cells[r][c] = value;

		for (int i = 0; i < R_OFFSETS.length; i++) {
			for (int j = 1; j <= size; j++) {
				cells[r + R_OFFSETS[i] * j][c + C_OFFSETS[i] * j] = value;
			}
		}
	}

	static boolean canFill(boolean[][] cells, int r, int c, int size) {
		if (!cells[r][c]) {
			return false;
		}

		int row = cells.length;
		int col = cells[0].length;

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int endR = r + R_OFFSETS[i] * size;
			int endC = c + C_OFFSETS[i] * size;

			if (!(endR >= 0 && endR < row && endC >= 0 && endC < col)) {
				return false;
			}

			for (int j = 1; j <= size; j++) {
				if (!cells[r + R_OFFSETS[i] * j][c + C_OFFSETS[i] * j]) {
					return false;
				}
			}
		}
		return true;
	}
}
