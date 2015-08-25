import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int presentCount = 0;
			for (int i = 0; i < N; i++) {
				int time = in.nextInt();
				if (time <= 0) {
					presentCount++;
				}
			}
			System.out.println(presentCount < K ? "YES" : "NO");
		}

		in.close();
	}
}
