import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();

			System.out.println(solve(x, y, z));
		}

		sc.close();
	}

	static String solve(int x, int y, int z) {
		int distanceA = Math.abs(x - z);
		int distanceB = Math.abs(y - z);

		if (distanceA < distanceB) {
			return "Cat A";
		} else if (distanceA > distanceB) {
			return "Cat B";
		} else {
			return "Mouse C";
		}
	}
}
