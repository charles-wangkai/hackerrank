import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			char[][] grid = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					grid[i][j] = line.charAt(j);
				}
			}

			System.out.println(solve(grid) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(char[][] grid) {
		Arrays.stream(grid).forEach(Arrays::sort);

		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > grid[i + 1][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
