import java.util.Scanner;

public class Solution {
	static final int SIZE = 15;
	static final int[] R_OFFSETS = { -1, 1, 2, 2 };
	static final int[] C_OFFSETS = { 2, 2, 1, -1 };

	static boolean[][] firstWins;

	public static void main(String[] args) {
		buildFirstWins();

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println(firstWins[x - 1][y - 1] ? "First" : "Second");
		}
		sc.close();
	}

	static void buildFirstWins() {
		firstWins = new boolean[SIZE][SIZE];
		for (int sum = 0; sum <= (SIZE - 1) * 2; sum++) {
			for (int r = 0; r <= sum; r++) {
				int c = sum - r;
				if (isInBoard(r, c) && !firstWins[r][c]) {
					for (int i = 0; i < R_OFFSETS.length; i++) {
						int nextR = r + R_OFFSETS[i];
						int nextC = c + C_OFFSETS[i];

						if (isInBoard(nextR, nextC)) {
							firstWins[nextR][nextC] = true;
						}
					}
				}
			}
		}
	}

	static boolean isInBoard(int r, int c) {
		return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
	}
}
