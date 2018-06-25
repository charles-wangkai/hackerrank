import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());

		int[] A = readArray(br, q);
		int[] B = readArray(br, q);

		StringBuilder sb = new StringBuilder();
		for (int element : solve(A, B)) {
			sb.append(element).append("\n");
		}
		System.out.print(sb);
	}

	static int[] readArray(BufferedReader br, int size) throws Throwable {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		return result;
	}

	static List<Integer> solve(int[] A, int[] B) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> numberToCount = new HashMap<>();
		Map<Integer, Set<Integer>> countToNumbers = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				int prevCount = numberToCount.getOrDefault(B[i], 0);
				int currCount = prevCount + 1;

				numberToCount.put(B[i], currCount);

				if (prevCount != 0) {
					countToNumbers.get(prevCount).remove(B[i]);
				}

				if (!countToNumbers.containsKey(currCount)) {
					countToNumbers.put(currCount, new HashSet<>());
				}
				countToNumbers.get(currCount).add(B[i]);
			} else if (A[i] == 2) {
				if (numberToCount.containsKey(B[i])) {
					int prevCount = numberToCount.get(B[i]);
					int currCount = prevCount - 1;

					if (currCount == 0) {
						numberToCount.remove(B[i]);
					} else {
						numberToCount.put(B[i], currCount);
					}

					countToNumbers.get(prevCount).remove(B[i]);

					if (currCount != 0) {
						countToNumbers.get(currCount).add(B[i]);
					}
				}
			} else if (A[i] == 3) {
				result.add(countToNumbers.getOrDefault(B[i], Collections.emptySet()).isEmpty() ? 0 : 1);
			}
		}
		return result;
	}
}
