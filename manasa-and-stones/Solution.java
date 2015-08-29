import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();

			Set<Integer> numbers = new HashSet<Integer>();
			numbers.add(0);
			for (int i = 0; i < n - 1; i++) {
				numbers = union(shift(numbers, a), shift(numbers, b));
			}

			Integer[] numberArray = numbers.toArray(new Integer[0]);
			Arrays.sort(numberArray);
			for (int i = 0; i < numberArray.length; i++) {
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(numberArray[i]);
			}
			System.out.println();
		}

		in.close();
	}

	static Set<Integer> shift(Set<Integer> numbers, int offset) {
		return numbers.stream().map(number -> number + offset)
				.collect(Collectors.toSet());
	}

	static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
		Set<Integer> result = new HashSet<Integer>();
		result.addAll(a);
		result.addAll(b);
		return result;
	}
}
