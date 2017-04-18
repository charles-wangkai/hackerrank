import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		int k = sc.nextInt();
		System.out.println(solve(s, t, k) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s, String t, int k) {
		if (k >= s.length() + t.length()) {
			return true;
		}

		for (int i = s.length();; i--) {
			String prefixS = s.substring(0, i);
			if (t.startsWith(prefixS)) {
				int diff = (s.length() - i) + (t.length() - i);
				return diff <= k && (k - diff) % 2 == 0;
			}
		}
	}
}
