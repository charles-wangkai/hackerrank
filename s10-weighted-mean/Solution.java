import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] x = readArray(sc, N);
		int[] w = readArray(sc, N);
		System.out.printf("%.1f\n", weightedMean(x, w));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}

	static double weightedMean(int[] x, int[] w) {
		return (double) IntStream.range(0, x.length).map(i -> x[i] * w[i]).sum() / Arrays.stream(w).sum();
	}
}
