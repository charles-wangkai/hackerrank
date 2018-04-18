import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] A = readArray(sc, n);
			int[] B = readArray(sc, n);

			System.out.println(solve(A, B, k));
		}

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static String solve(int[] A, int[] B, int k) {
		int n = A.length;

		Arrays.sort(A);
		Arrays.sort(B);

		return IntStream.range(0, n).allMatch(i -> A[i] + B[n - 1 - i] >= k) ? "YES" : "NO";
	}
}
