import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String message = in.next();

		int length = message.length();
		int row = (int) Math.round(Math.sqrt(length));
		if (row * row > length) {
			row--;
		}
		int col;
		if (row * row == length) {
			col = row;
		} else if (row * (row + 1) >= length) {
			col = row + 1;
		} else {
			row++;
			col = row;
		}

		char[][] grid = new char[row][col];
		int r = 0;
		int c = 0;
		for (int i = 0; i < length; i++) {
			grid[r][c] = message.charAt(i);

			c++;
			if (c == col) {
				r++;
				c = 0;
			}
		}

		StringBuilder encoded = new StringBuilder();
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (grid[j][i] != 0) {
					encoded.append(grid[j][i]);
				}
			}
			encoded.append(" ");
		}
		System.out.println(encoded);

		in.close();
	}
}
