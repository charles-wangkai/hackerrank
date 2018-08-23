
// https://blog.csdn.net/rcy_zhu/article/details/74930995

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			Triplet[] points = new Triplet[4];
			for (int i = 0; i < points.length; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();

				points[i] = new Triplet(x, y, z);
			}

			System.out.println(solve(points) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(Triplet[] points) {
		Triplet[] vectors = new Triplet[points.length - 1];
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Triplet(points[i + 1].x - points[0].x, points[i + 1].y - points[0].y,
					points[i + 1].z - points[0].z);
		}

		return (long) vectors[0].x * vectors[1].y * vectors[2].z + (long) vectors[1].x * vectors[2].y * vectors[0].z
				+ (long) vectors[2].x * vectors[0].y * vectors[1].z - (long) vectors[0].x * vectors[2].y * vectors[1].z
				- (long) vectors[1].x * vectors[0].y * vectors[2].z
				- (long) vectors[2].x * vectors[1].y * vectors[0].z == 0;
	}
}

class Triplet {
	int x;
	int y;
	int z;

	Triplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}