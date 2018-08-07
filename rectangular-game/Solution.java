import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b));

		sc.close();
	}

	static long solve(int[] a, int[] b) {
		return (long) Arrays.stream(a).min().getAsInt() * Arrays.stream(b).min().getAsInt();
	}
}
