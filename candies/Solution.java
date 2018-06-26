import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr));

		sc.close();
	}

	static long solve(int[] arr) {
		int[] lefts = new int[arr.length];
		int previous = Integer.MAX_VALUE;
		for (int i = 0; i < lefts.length; i++) {
			if (arr[i] > previous) {
				lefts[i] = lefts[i - 1] + 1;
			} else {
				lefts[i] = 1;
			}

			previous = arr[i];
		}

		int[] rights = new int[arr.length];
		previous = Integer.MAX_VALUE;
		for (int i = rights.length - 1; i >= 0; i--) {
			if (arr[i] > previous) {
				rights[i] = rights[i + 1] + 1;
			} else {
				rights[i] = 1;
			}

			previous = arr[i];
		}

		return IntStream.range(0, arr.length).mapToLong(i -> Math.max(lefts[i], rights[i])).sum();
	}
}
