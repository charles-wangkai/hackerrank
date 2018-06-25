import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] q = new int[n];
			for (int i = 0; i < q.length; i++) {
				q[i] = sc.nextInt();
			}

			int solution = solve(q);
			System.out.println(solution >= 0 ? solution : "Too chaotic");
		}

		sc.close();
	}

	static int solve(int[] q) {
		if (!isValid(q)) {
			return -1;
		}

		int swapNum = 0;
		LinkedList<Integer> target = new LinkedList<>(Arrays.stream(q).sorted().boxed().collect(Collectors.toList()));
		for (int number : q) {
			int index = target.indexOf(number);
			if (index >= 3) {
				return -1;
			}

			swapNum += index;
			target.remove(index);
		}
		return swapNum;
	}

	static boolean isValid(int[] q) {
		return Arrays.stream(q).min().getAsInt() == 1 && Arrays.stream(q).max().getAsInt() == q.length
				&& Arrays.stream(q).distinct().count() == q.length;
	}
}
