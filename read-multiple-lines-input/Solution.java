import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
		}

		in.close();
	}
}
