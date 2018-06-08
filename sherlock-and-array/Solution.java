import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		int leftSum = 0;
		int rightSum = Arrays.stream(a).sum();
		for (int number : a) {
			rightSum -= number;

			if (leftSum == rightSum) {
				return true;
			}

			leftSum += number;
		}
		return false;
	}
}
