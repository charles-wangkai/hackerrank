import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		Arrays.sort(a);
		return IntStream.range(0, a.length - 1).map(i -> a[i + 1] - a[i]).min().getAsInt();
	}
}
