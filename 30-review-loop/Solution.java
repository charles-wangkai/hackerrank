import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < T; tc++) {
			String S = sc.nextLine();

			printEveryOtherCharacters(S, 0);
			System.out.print(" ");
			printEveryOtherCharacters(S, 1);
			System.out.println();
		}

		sc.close();
	}

	static void printEveryOtherCharacters(String s, int beginIndex) {
		for (int i = beginIndex; i < s.length(); i += 2) {
			System.out.print(s.charAt(i));
		}
	}
}
