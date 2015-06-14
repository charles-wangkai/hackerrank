import java.util.Scanner;

public class Solution {
	static final int MODULO = 1234567;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = in.nextInt();
			int routeNum = 1;
			for (int i = 0; i < N - 1; i++) {
				routeNum = multiplyMod(routeNum, in.nextInt());
			}
			System.out.println(routeNum);
		}

		in.close();
	}

	static int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}
}
