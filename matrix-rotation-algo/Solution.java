import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int M = in.nextInt();
		int N = in.nextInt();
		int R = in.nextInt();
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		int[][] rotated = new int[M][N];
		for (int i = 0; i * 2 < Math.min(M, N); i++) {
			int height = M - i * 2;
			int width = N - i * 2;
			int circumference = (height + width - 2) * 2;
			int offset = R % circumference;

			Point from = new Point(i, i);
			Point to = new Point(i, i);
			for (int j = 0; j < offset; j++) {
				to = move(to, M, N);
			}

			for (int j = 0; j < circumference; j++) {
				rotated[to.r][to.c] = matrix[from.r][from.c];

				from = move(from, M, N);
				to = move(to, M, N);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print(rotated[i][j]);
			}
			System.out.println();
		}

		in.close();
	}

	static Point move(Point p, int M, int N) {
		int circle = Math.min(Math.min(p.r, M - 1 - p.r),
				Math.min(p.c, N - 1 - p.c));
		int height = M - circle * 2;
		int width = N - circle * 2;

		if (p.c == circle && p.r < circle + height - 1) {
			return new Point(p.r + 1, p.c);
		} else if (p.r == M - 1 - circle && p.c < circle + width - 1) {
			return new Point(p.r, p.c + 1);
		} else if (p.c == N - 1 - circle && p.r > circle) {
			return new Point(p.r - 1, p.c);
		} else {
			return new Point(p.r, p.c - 1);
		}
	}
}

class Point {
	int r;
	int c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}