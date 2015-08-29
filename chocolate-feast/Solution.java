import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = in.nextInt();
			int C = in.nextInt();
			int M = in.nextInt();

			int count = N / C;
			int wrapperNum = count;
			while (wrapperNum >= M) {
				int exchangeNum = wrapperNum / M;
				count += exchangeNum;
				wrapperNum = exchangeNum + wrapperNum % M;
			}
			System.out.println(count);
		}

		in.close();
	}
}
