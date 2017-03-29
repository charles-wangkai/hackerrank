import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int result = 1;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (isBetter(i, result)) {
					result = i;
				}
				if (isBetter(n / i, result)) {
					result = n / i;
				}
			}
		}
		return result;
	}

	static boolean isBetter(int n1, int n2) {
		int digitSum1 = computeDigitSum(n1);
		int digitSum2 = computeDigitSum(n2);
		return digitSum1 > digitSum2 || (digitSum1 == digitSum2 && n1 < n2);
	}

	static int computeDigitSum(int x) {
		int digitSum = 0;
		while (x != 0) {
			digitSum += x % 10;
			x /= 10;
		}
		return digitSum;
	}
}
