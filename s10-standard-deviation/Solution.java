import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] x = new int[N];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}

		System.out.printf("%.1f\n", std(x));

		sc.close();
	}

	static double std(int[] x) {
		double m = mean(x);

		return Math.sqrt(Arrays.stream(x).mapToDouble(oneX -> Math.pow(oneX - m, 2)).sum() / x.length);
	}

	static double mean(int[] x) {
		return (double) Arrays.stream(x).sum() / x.length;
	}
}
