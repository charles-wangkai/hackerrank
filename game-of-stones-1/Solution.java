import java.util.Scanner;

public class Solution {
	static final int LIMIT = 100;
	static final int[] STONES_IN_ONE_MOVE = { 2, 3, 5 };

	static boolean[] firstWins;

	public static void main(String[] args) {
		buildFirstWins();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			System.out.println(firstWins[n] ? "First" : "Second");
		}
		sc.close();
	}

	static void buildFirstWins() {
		firstWins = new boolean[LIMIT + 1];
		for (int i = 0; i < firstWins.length; i++) {
			for (int stone : STONES_IN_ONE_MOVE) {
				if (i >= stone && !firstWins[i - stone]) {
					firstWins[i] = true;
					break;
				}
			}
		}
	}
}
