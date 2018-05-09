import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		return Arrays.stream(a).map(number -> String.valueOf(number).chars().map(ch -> ch - '0').sum()).sum() % 3 == 0;
	}
}
