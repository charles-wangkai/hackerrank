import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

		Result result = solve(a);
		if (result.possible) {
			System.out.println("yes");

			if (result.operation != null) {
				System.out.println(
						String.format("%s %d %d", result.operation, result.lowerIndex + 1, result.upperIndex + 1));
			}
		} else {
			System.out.println("no");
		}

		sc.close();
	}

	static Result solve(int[] a) {
		int[] sorted = Arrays.stream(a).sorted().toArray();
		List<Integer> diffIndices = compare(a, sorted);
		int firstDiffIndex = diffIndices.get(0);
		int lastDiffIndex = diffIndices.get(diffIndices.size() - 1);

		if (diffIndices.isEmpty()) {
			return new Result(true, null, -1, -1);
		} else if (diffIndices.size() == 2) {
			return new Result(true, "swap", firstDiffIndex, lastDiffIndex);
		}

		reverse(a, firstDiffIndex, lastDiffIndex);
		if (compare(a, sorted).isEmpty()) {
			return new Result(true, "reverse", firstDiffIndex, lastDiffIndex);
		} else {
			return new Result(false, null, -1, -1);
		}
	}

	static List<Integer> compare(int[] x, int[] y) {
		return IntStream.range(0, x.length).filter(i -> x[i] != y[i]).boxed().collect(Collectors.toList());
	}

	static void reverse(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}

class Result {
	boolean possible;
	String operation;
	int lowerIndex;
	int upperIndex;

	Result(boolean possible, String operation, int lowerIndex, int upperIndex) {
		this.possible = possible;
		this.operation = operation;
		this.lowerIndex = lowerIndex;
		this.upperIndex = upperIndex;
	}
}