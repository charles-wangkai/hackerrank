import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		while (true) {
			int index = findSameIndex(s);

			if (index < 0) {
				return s.isEmpty() ? "Empty String" : s;
			}

			s = s.substring(0, index) + s.substring(index + 2);
		}
	}

	static int findSameIndex(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return i;
			}
		}
		return -1;
	}
}
