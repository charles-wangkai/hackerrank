import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] xs = new int[N];
		int[] ys = new int[N];
		for (int i = 0; i < N; i++) {
			xs[i] = sc.nextInt();
			ys[i] = sc.nextInt();
		}
		System.out.println(solve(xs, ys));

		sc.close();
	}

	static double solve(int[] xs, int[] ys) {
		int minX = Arrays.stream(xs).min().getAsInt();
		int maxX = Arrays.stream(xs).max().getAsInt();
		int minY = Arrays.stream(ys).min().getAsInt();
		int maxY = Arrays.stream(ys).max().getAsInt();

		return Math.max(Math.max(maxX - minX, maxY - minY), Math.sqrt(
				square(Math.max(Math.abs(minX), Math.abs(maxX))) + square(Math.max(Math.abs(minY), Math.abs(maxY)))));
	}

	static long square(int x) {
		return (long) x * x;
	}
}
