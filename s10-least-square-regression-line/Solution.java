import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> xs = new ArrayList<Integer>();
		List<Integer> ys = new ArrayList<Integer>();
		while (sc.hasNextInt()) {
			xs.add(sc.nextInt());
			ys.add(sc.nextInt());
		}
		System.out.printf("%.3f\n", solve(xs, ys, 80));

		sc.close();
	}

	static double solve(List<Integer> xs, List<Integer> ys, int predictX) {
		int n = xs.size();
		int sumX = sum(xs);
		double meanX = mean(xs);
		int sumY = sum(ys);
		double meanY = mean(ys);
		int sumXX = sumOfProduct(xs, xs);
		int sumXY = sumOfProduct(xs, ys);

		double b = (double) (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
		double a = meanY - b * meanX;

		return a + b * predictX;
	}

	static int sum(List<Integer> ps) {
		return ps.stream().mapToInt(x -> x).sum();
	}

	static double mean(List<Integer> ps) {
		return (double) sum(ps) / ps.size();
	}

	static int sumOfProduct(List<Integer> ps, List<Integer> qs) {
		return IntStream.range(0, ps.size()).map(i -> ps.get(i) * qs.get(i)).sum();
	}
}
