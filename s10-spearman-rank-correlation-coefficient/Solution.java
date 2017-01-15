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

	static double solve(double[] x, double[] y) {
		int n = x.length;
		int[] rankX = rank(x);
		int[] rankY = rank(y);

		return 1 - 6.0 * IntStream.range(0, n).map(i -> (rankX[i] - rankY[i]) * (rankX[i] - rankY[i])).sum()
				/ (n * (n * n - 1));
	}

	static double[] readArray(Scanner sc, int size) {
		double[] result = new double[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextDouble();
		}
		return result;
	}

	static int[] rank(double[] a) {
		return IntStream.range(0, a.length).map(i -> (int) (Arrays.stream(a).filter(x -> x < a[i]).count()) + 1)
				.toArray();
	}
}
