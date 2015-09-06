import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int B = in.nextInt();
			int W = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			int Z = in.nextInt();

			long cost;
			if (X + Z < Y) {
				cost = (long) X * B + (long) (X + Z) * W;
			} else if (Y + Z < X) {
				cost = (long) (Y + Z) * B + (long) Y * W;
			} else {
				cost = (long) X * B + (long) Y * W;
			}
			System.out.println(cost);
		}

		in.close();
	}
}
