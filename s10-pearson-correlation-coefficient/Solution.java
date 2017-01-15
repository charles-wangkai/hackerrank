import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double[] x = readArray(sc, n);
		double[] y = readArray(sc, n);

		System.out.printf("%.3f\n", solve(x, y));

		sc.close();
	}

	static double[] readArray(Scanner sc, int size) {
		double[] result = new double[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextDouble();
		}
		return result;
	}

	static double solve(double[] x, double[] y) {
		double meanX = mean(x);
		double meanY = mean(y);

		return IntStream.range(0, x.length).mapToDouble(i -> (x[i] - meanX) * (y[i] - meanY)).sum()
				/ (x.length * std(x) * std(y));
	}

	static double mean(double[] a) {
		return Arrays.stream(a).average().getAsDouble();
	}

	static double std(double[] a) {
		double meanA = mean(a);
		return Math.sqrt(IntStream.range(0, a.length).mapToDouble(i -> Math.pow(a[i] - meanA, 2)).sum() / a.length);
	}
}
