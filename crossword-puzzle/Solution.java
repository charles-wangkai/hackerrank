import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	static final int SIZE = 10;
	static final int[] R_OFFSETS = { 0, 1 };
	static final int[] C_OFFSETS = { 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] grid = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			String line = sc.next();
			for (int c = 0; c < SIZE; c++) {
				grid[r][c] = line.charAt(c);
			}
		}
		String[] words = sc.next().split(";");

		char[][] solution = solve(grid, words);
		IntStream.range(0, SIZE).forEach(r -> System.out.println(String.valueOf(solution[r])));

		sc.close();
	}

	static char[][] solve(char[][] grid, String[] words) {
		return search(grid, Arrays.stream(words).collect(Collectors.toSet()), 0, 0, 0);
	}

	static char[][] search(char[][] grid, Set<String> remainWords, int r, int c, int direction) {
		if (r == SIZE) {
			return grid;
		}
		if (c == SIZE) {
			return search(grid, remainWords, r + 1, 0, 0);
		}
		if (direction == R_OFFSETS.length) {
			return search(grid, remainWords, r, c + 1, 0);
		}

		int insertLength = countInsertLength(grid, r, c, direction);
		if (insertLength > 1) {
			for (String remainWord : new ArrayList<>(remainWords)) {
				if (canInsert(grid, r, c, direction, insertLength, remainWord)) {
					List<Integer> insertOffsets = new ArrayList<Integer>();

					for (int insertOffset = 0; insertOffset < insertLength; insertOffset++) {
						int insertR = r + R_OFFSETS[direction] * insertOffset;
						int insertC = c + C_OFFSETS[direction] * insertOffset;

						if (grid[insertR][insertC] == '-') {
							grid[insertR][insertC] = remainWord.charAt(insertOffset);

							insertOffsets.add(insertOffset);
						}
					}
					remainWords.remove(remainWord);

					char[][] subResult = search(grid, remainWords, r, c, direction + 1);
					if (subResult != null) {
						return subResult;
					}

					remainWords.add(remainWord);
					for (int insertOffset : insertOffsets) {
						int insertR = r + R_OFFSETS[direction] * insertOffset;
						int insertC = c + C_OFFSETS[direction] * insertOffset;

						grid[insertR][insertC] = '-';
					}
				}
			}

			return null;
		} else {
			return search(grid, remainWords, r, c, direction + 1);
		}
	}

	static int countInsertLength(char[][] grid, int r, int c, int direction) {
		int prevR = r - R_OFFSETS[direction];
		int prevC = c - C_OFFSETS[direction];
		if (prevR >= 0 && prevR < SIZE && prevC >= 0 && prevC < SIZE && grid[prevR][prevC] != '+') {
			return 0;
		}

		int insertLength = 0;
		while (r >= 0 && r < SIZE && c >= 0 && c < SIZE && grid[r][c] != '+') {
			insertLength++;

			r += R_OFFSETS[direction];
			c += C_OFFSETS[direction];
		}
		return insertLength;
	}

	static boolean canInsert(char[][] grid, int r, int c, int direction, int insertLength, String word) {
		return word.length() == insertLength && IntStream.range(0, word.length()).allMatch(insertOffset -> {
			int insertR = r + R_OFFSETS[direction] * insertOffset;
			int insertC = c + C_OFFSETS[direction] * insertOffset;

			return grid[insertR][insertC] == '-' || grid[insertR][insertC] == word.charAt(insertOffset);
		});
	}
}
