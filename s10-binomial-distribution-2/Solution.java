import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double defectPercent = sc.nextDouble();
		int n = sc.nextInt();

		System.out.printf("%.3f\n",
				IntStream.rangeClosed(0, 2).mapToDouble(rejectNum -> solve(defectPercent, n, rejectNum)).sum());
		System.out.printf("%.3f\n",
				IntStream.rangeClosed(2, n).mapToDouble(rejectNum -> solve(defectPercent, n, rejectNum)).sum());

		sc.close();
	}

	static double solve(double defectPercent, int n, int rejectNum) {
		double defectP = defectPercent / 100;
		return C(n, rejectNum) * Math.pow(defectP, rejectNum) * Math.pow(1 - defectP, n - rejectNum);
	}

	static int C(int n, int r) {
		int result = 1;
		for (int i = 0; i < r; i++) {
			result = result * (n - i) / (i + 1);
		}
		return result;
	}
}
