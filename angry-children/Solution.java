import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr, k));

		sc.close();
	}

	static int solve(int[] arr, int k) {
		Arrays.sort(arr);

		return IntStream.range(0, arr.length - k + 1).map(i -> arr[i + k - 1] - arr[i]).min().getAsInt();
	}
}
