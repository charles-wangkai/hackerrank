import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
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
		int[] ascending = Arrays.copyOf(a, a.length);
		Arrays.sort(ascending);

		int[] descending = Arrays.copyOf(ascending, ascending.length);
		reverse(descending);

		return Math.min(findSwapNum(a, ascending), findSwapNum(a, descending));
	}

	static void reverse(int[] x) {
		for (int i = 0, j = x.length - 1; i < j; i++, j--) {
			swap(x, i, j);
		}
	}

	static void swap(int[] x, int index1, int index2) {
		int temp = x[index1];
		x[index1] = x[index2];
		x[index2] = temp;
	}

	static int findSwapNum(int[] a, int[] target) {
		int[] current = Arrays.copyOf(a, a.length);
		Map<Integer, Integer> valueToIndex = IntStream.range(0, current.length).boxed()
				.collect(Collectors.toMap(i -> current[i], Function.identity()));

		int swapNum = 0;
		for (int i = 0; i < current.length; i++) {
			if (current[i] != target[i]) {
				int otherIndex = valueToIndex.get(target[i]);

				valueToIndex.put(target[i], i);
				valueToIndex.put(current[i], otherIndex);

				swap(current, i, otherIndex);

				swapNum++;
			}
		}
		return swapNum;
	}
}
