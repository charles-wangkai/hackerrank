import java.util.Scanner;

public class Solution {
	static final int[] OFFSET_R = { -1, 0, 1, 0 };
	static final int[] OFFSET_C = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = in.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(isCavity(map, i, j) ? 'X' : (map[i][j] + ""));
			}
			System.out.println();
		}

		in.close();
	}

	static boolean isCavity(int[][] map, int r, int c) {
		int size = map.length;
		for (int i = 0; i < OFFSET_R.length; i++) {
			int adjR = r + OFFSET_R[i];
			int adjC = c + OFFSET_C[i];
			if (!(adjR >= 0 && adjR < size && adjC >= 0 && adjC < size && map[adjR][adjC] < map[r][c])) {
				return false;
			}
		}
		return true;
	}
}
