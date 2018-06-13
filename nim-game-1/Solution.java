
// https://en.wikipedia.org/wiki/Nim#Proof_of_the_winning_formula

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int g = sc.nextInt();
		for (int tc = 0; tc < g; tc++) {
			int n = sc.nextInt();
			int[] piles = new int[n];
			for (int i = 0; i < piles.length; i++) {
				piles[i] = sc.nextInt();
			}

			System.out.println(solve(piles));
		}

		sc.close();
	}

	static String solve(int[] piles) {
		return Arrays.stream(piles).reduce((result, pile) -> result ^ pile).getAsInt() != 0 ? "First" : "Second";
	}
}
