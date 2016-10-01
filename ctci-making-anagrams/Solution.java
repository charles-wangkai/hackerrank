import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		int[] letter2countA = buildLetter2ccount(a);
		int[] letter2countB = buildLetter2ccount(b);

		int deletion = 0;
		for (int i = 0; i < letter2countA.length; i++) {
			deletion += Math.abs(letter2countA[i] - letter2countB[i]);
		}
		System.out.println(deletion);

		sc.close();
	}

	static int[] buildLetter2ccount(String s) {
		int[] letter2count = new int[26];
		s.chars().forEach(letter -> letter2count[letter - 'a']++);
		return letter2count;
	}
}
