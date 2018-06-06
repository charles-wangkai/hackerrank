import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			String s = sc.next();

			System.out.println(solve(s) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s) {
		String target = "hackerrank";
		int index = 0;
		for (char ch : s.toCharArray()) {
			if (ch == target.charAt(index)) {
				index++;
			}

			if (index == target.length()) {
				return true;
			}
		}
		return false;
	}
}
