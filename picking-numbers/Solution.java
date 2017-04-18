import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final int LIMIT = 100;

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
		int[] counts = new int[LIMIT];
		for (int number : a) {
			counts[number]++;
		}

		int result = Arrays.stream(counts).max().getAsInt();
		for (int i = 0; i + 1 < counts.length; i++) {
			result = Math.max(result, counts[i] + counts[i + 1]);
		}
		return result;
	}
}
