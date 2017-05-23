import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < points.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int v = sc.nextInt();

			points[i] = new Point(x, y, v);
		}
		System.out.println(solve(points));

		sc.close();
	}

	static int solve(Point[] points) {
		if (points.length == 1) {
			return 0;
		}

		if (points.length == 2) {
			if (points[0].x == points[1].x && points[0].y == points[1].y) {
				return 0;
			} else {
				return Math.min(points[0].v, points[1].v);
			}
		}

		int result = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int leftWeight = 0;
				int rightWeight = 0;

				for (int k = 0; k < points.length; k++) {
					if (k == i || k == j) {
						continue;
					}

					if (computeCrossProduct(points[i], points[j], points[k]) > 0) {
						leftWeight += points[k].v;
					} else {
						rightWeight += points[k].v;
					}
				}

				result = Math.max(result,
						Math.max(
								Math.max(Math.min(leftWeight + points[i].v + points[j].v, rightWeight),
										Math.min(leftWeight + points[i].v, rightWeight + points[j].v)),
								Math.max(Math.min(leftWeight + points[j].v, rightWeight + points[i].v),
										Math.min(leftWeight, rightWeight + points[i].v + points[j].v))));
			}
		}
		return result;
	}

	static long computeCrossProduct(Point p0, Point p1, Point p2) {
		int x1 = p1.x - p0.x;
		int y1 = p1.y - p0.y;
		int x2 = p2.x - p0.x;
		int y2 = p2.y - p0.y;

		return (long) x1 * y2 - (long) x2 * y1;
	}
}

class Point {
	int x;
	int y;
	int v;

	Point(int x, int y, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}
}