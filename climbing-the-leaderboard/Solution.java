import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}
		int[] ranks = buildRanks(scores);

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int alice = sc.nextInt();
			System.out.println(solve(scores, ranks, alice));
		}

		sc.close();
	}

	static int[] buildRanks(int[] scores) {
		int[] ranks = new int[scores.length];
		int rank = 1;
		for (int i = 0; i < ranks.length; i++) {
			if (i > 0 && scores[i] != scores[i - 1]) {
				rank++;
			}
			ranks[i] = rank;
		}
		return ranks;
	}

	static int solve(int[] scores, int[] ranks, int alice) {
		int lower = 0;
		int upper = scores.length - 1;
		int aliceRank = 1;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;
			if (alice == scores[middle]) {
				aliceRank = ranks[middle];
				break;
			} else if (alice < scores[middle]) {
				aliceRank = ranks[middle] + 1;
				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}
		return aliceRank;
	}
}
