import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double lambda = sc.nextDouble();
		int k = sc.nextInt();

		System.out.printf("%.3f\n", solve(lambda, k));

		sc.close();
	}

	static double solve(double lambda, int k) {
		return Math.pow(lambda, k) * Math.exp(-lambda) / factorial(k);
	}

	static int factorial(int n) {
		return IntStream.rangeClosed(1, n).reduce((x, y) -> x * y).getAsInt();
	}
}
