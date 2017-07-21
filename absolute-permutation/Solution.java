import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] result = solve(N, K);
			System.out.println(result == null ? -1
					: String.join(" ", Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.toList())));
		}

		sc.close();
	}

	static int[] solve(int N, int K) {
		if (K > 0 && N % (2 * K) != 0) {
			return null;
		}

		int[] original = IntStream.range(1, N + 1).toArray();
		boolean[] used = new boolean[original.length];

		int[] result = new int[original.length];
		for (int i = 0; i < original.length; i++) {
			if (!used[i]) {
				result[i] = original[i + K];
				result[i + K] = original[i];

				used[i] = true;
				used[i + K] = true;
			}
		}
		return result;
	}
}
