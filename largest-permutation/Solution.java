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
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println(Arrays.stream(solve(a, k)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int[] a, int k) {
		Map<Integer, Integer> numberToIndex = IntStream.range(0, a.length).boxed()
				.collect(Collectors.toMap(i -> a[i], Function.identity()));

		int index = 0;
		for (int i = 0; i < k; i++) {
			while (index < a.length && a[index] == a.length - index) {
				index++;
			}

			if (index == a.length) {
				break;
			}

			swap(a, numberToIndex, index, numberToIndex.get(a.length - index));
			index++;
		}

		return a;
	}

	static void swap(int[] a, Map<Integer, Integer> numberToIndex, int index1, int index2) {
		int number1 = a[index1];
		int number2 = a[index2];

		a[index1] = number2;
		a[index2] = number1;

		numberToIndex.put(number1, index2);
		numberToIndex.put(number2, index1);
	}
}
