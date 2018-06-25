import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solve(arr, r));

		sc.close();
	}

	static long solve(int[] arr, int r) {
		Map<Integer, List<Integer>> numberToIndices = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!numberToIndices.containsKey(arr[i])) {
				numberToIndices.put(arr[i], new ArrayList<>());
			}

			numberToIndices.get(arr[i]).add(i);
		}

		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % r != 0) {
				continue;
			}

			int firstNumber = arr[i] / r;

			if ((long) arr[i] * r > Integer.MAX_VALUE) {
				continue;
			}

			int lastNumber = arr[i] * r;

			result += (long) findBeforeCount(numberToIndices, firstNumber, i)
					* findAfterCount(numberToIndices, lastNumber, i);
		}
		return result;
	}

	static int findBeforeCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
		if (!numberToIndices.containsKey(number)) {
			return 0;
		}

		List<Integer> indices = numberToIndices.get(number);
		int position = Collections.binarySearch(indices, index);
		if (position < 0) {
			position = -1 - position;
		}

		return position;
	}

	static int findAfterCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
		if (!numberToIndices.containsKey(number)) {
			return 0;
		}

		List<Integer> indices = numberToIndices.get(number);
		int position = Collections.binarySearch(indices, index);
		if (position < 0) {
			position = -1 - position - 1;
		}

		return indices.size() - 1 - position;
	}
}
