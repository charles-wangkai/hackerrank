import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(String n, int k) {
		long result = (long) computeDigitSum(n) * k;
		while (result >= 10) {
			result = computeDigitSum(String.valueOf(result));
		}
		return (int) result;
	}

	static int computeDigitSum(String s) {
		return s.chars().map(ch -> ch - '0').sum();
	}
}
