import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double lambdaA = sc.nextDouble();
		double lambdaB = sc.nextDouble();

		System.out.printf("%.3f\n", solve(lambdaA, 160, 40));
		System.out.printf("%.3f\n", solve(lambdaB, 128, 40));

		sc.close();
	}

	static double solve(double lambda, int a, int b) {
		double result = 0;
		for (int k = 0;; k++) {
			double p = Math.pow(lambda, k) * Math.exp(-lambda) / factorial(k);
			double addition = p * (a + b * k * k);

			if (addition < 1e-3) {
				break;
			}

			result += addition;
		}
		return result;
	}

	static int factorial(int n) {
		return (n == 0) ? 1 : IntStream.rangeClosed(1, n).reduce((x, y) -> x * y).getAsInt();
	}
}
