import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = in.nextInt();
			int height = 1;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					height *= 2;
				} else {
					height++;
				}
			}
			System.out.println(height);
		}

		in.close();
	}
}
