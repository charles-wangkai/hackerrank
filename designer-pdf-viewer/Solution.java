import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] h = new int[26];
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
		}
		String word = sc.next();
		System.out.println(solve(h, word));

		sc.close();
	}

	static int solve(int[] h, String word) {
		return word.length() * word.chars().map(c -> h[c - 'a']).max().getAsInt();
	}
}
