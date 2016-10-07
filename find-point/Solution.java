import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int px = sc.nextInt();
			int py = sc.nextInt();
			int qx = sc.nextInt();
			int qy = sc.nextInt();

			System.out.printf("%d %d\n", qx * 2 - px, qy * 2 - py);
		}

		sc.close();
	}
}
