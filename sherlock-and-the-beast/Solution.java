import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = in.nextInt();

			int offset = divideToCeil(N, 3);
			int x = N * 2 - offset * 5;
			int y = -N + offset * 3;

			if (x < 0) {
				System.out.println(-1);
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 3 * x; i++) {
					sb.append("5");
				}
				for (int i = 0; i < 5 * y; i++) {
					sb.append("3");
				}
				System.out.println(sb);
			}
		}

		in.close();
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
