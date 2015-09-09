import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String S = in.next();
			System.out.println(isFunny(S) ? "Funny" : "Not Funny");
		}

		in.close();
	}

	static boolean isFunny(String str) {
		for (int i = 1, j = str.length() - 2; i <= j; i++, j--) {
			if (Math.abs(str.charAt(i) - str.charAt(i - 1)) != Math.abs(str.charAt(j) - str.charAt(j + 1))) {
				return false;
			}
		}
		return true;
	}
}
