import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long N = in.nextLong();
			System.out.println((N + "").chars()
					.filter(digit -> digit != '0' && N % (digit - '0') == 0)
					.count());
		}

		in.close();
	}
}
