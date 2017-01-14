import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double boy = sc.nextDouble();
		double girl = sc.nextDouble();

		System.out.printf("%.3f\n", solve(boy, girl, 6, 3));

		sc.close();
	}

	static double solve(double boy, double girl, int n, int minBoy) {
		double boyP = boy / (boy + girl);

		double result = 0;
		for (int boyNum = minBoy; boyNum <= n; boyNum++) {
			result += C(n, boyNum) * Math.pow(boyP, boyNum) * Math.pow(1 - boyP, n - boyNum);
		}
		return result;
	}

	static int C(int n, int r) {
		int result = 1;
		for (int i = 0; i < r; i++) {
			result = result * (n - i) / (i + 1);
		}
		return result;
	}
}
