import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			Point[] points = new Point[n];
			for (int i = 0; i < points.length; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				points[i] = new Point(x, y);
			}

			System.out.println(solve(points) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(Point[] points) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (Point point : points) {
			minX = Math.min(minX, point.x);
			maxX = Math.max(maxX, point.x);
			minY = Math.min(minY, point.y);
			maxY = Math.max(maxY, point.y);
		}

		return check(points, minX, maxX, minY, maxY);
	}

	static boolean check(Point[] points, int minX, int maxX, int minY, int maxY) {
		return Arrays.stream(points)
				.allMatch(point -> point.x == minX || point.x == maxX || point.y == minY || point.y == maxY);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}