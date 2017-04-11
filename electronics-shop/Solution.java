import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] keyboards = readArray(sc, n);
		int[] drives = readArray(sc, m);
		System.out.println(solve(s, keyboards, drives));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int s, int[] keyboards, int[] drives) {
		int result = -1;

		Arrays.sort(drives);

		for (int keyboard : keyboards) {
			int index = Arrays.binarySearch(drives, s - keyboard);
			if (index < 0) {
				index = -1 - index - 1;
			}

			if (index >= 0) {
				result = Math.max(result, keyboard + drives[index]);
			}
		}

		return result;
	}
}
