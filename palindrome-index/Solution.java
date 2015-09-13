import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = in.next();
			System.out.println(findRemovalIndex(str));
		}

		in.close();
	}

	static int findRemovalIndex(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return isPalindrome(str, i + 1, j) ? i : j;
			}
		}
		return -1;
	}

	static boolean isPalindrome(String str, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
