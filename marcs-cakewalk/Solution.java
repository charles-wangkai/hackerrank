import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c));

		sc.close();
	}

	static long solve(int[] c) {
		Arrays.sort(c);
		return IntStream.range(0, c.length).mapToLong(i -> c[c.length - i - 1] * (1L << i)).sum();
	}
}
