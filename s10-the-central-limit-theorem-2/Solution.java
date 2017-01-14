import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int maxTicketNum = sc.nextInt();
		int n = sc.nextInt();
		double mean = sc.nextDouble();
		double std = sc.nextDouble();

		System.out.printf("%.4f\n", solve(maxTicketNum, n, mean, std));

		sc.close();
	}

	static double solve(int maxTicketNum, int n, double mean, double std) {
		return phi(n * mean, Math.sqrt(n) * std, maxTicketNum);
	}

	static double phi(double mean, double std, double x) {
		return 0.5 * (1 + erf((x - mean) / (std * Math.sqrt(2))));
	}

	// https://en.wikipedia.org/wiki/Error_function#Taylor_series
	static double erf(double z) {
		double result = 0;
		for (int n = 0;; n++) {
			double term = 2 / Math.sqrt(Math.PI) * ((n % 2 == 0) ? 1 : -1) * Math.pow(z, 2 * n + 1)
					/ (factorial(n) * (2 * n + 1));

			if (Math.abs(term) < 1e-5) {
				break;
			}

			result += term;
		}
		return result;
	}

	static double factorial(int n) {
		return IntStream.rangeClosed(1, n).mapToDouble(x -> x).reduce(1, (x, y) -> x * y);
	}
}
