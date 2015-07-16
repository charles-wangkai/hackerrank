import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int A = in.nextInt();
			int B = in.nextInt();
			System.out.println(A + B);
		}

		in.close();
	}
}
