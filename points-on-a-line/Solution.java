import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i < points.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			points[i] = new Point(x, y);
		}
		System.out.println(solve(points) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(Point[] points) {
		return Arrays.stream(points).map(point -> point.x).collect(Collectors.toSet()).size() == 1
				|| Arrays.stream(points).map(point -> point.y).collect(Collectors.toSet()).size() == 1;
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