import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String s = sc.next();
			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(String s) {
		return (int) s.chars().distinct().count();
	}
}
