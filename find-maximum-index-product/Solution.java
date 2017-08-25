import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] lefts = buildClosests(a, IntStream.range(0, a.length).toArray());
		int[] rights = buildClosests(a, IntStream.range(0, a.length).map(i -> a.length - 1 - i).toArray());

		long maxProduct = Long.MIN_VALUE;
		for (int i = 0; i < lefts.length; i++) {
			maxProduct = Math.max(maxProduct, (long) lefts[i] * rights[i]);
		}
		System.out.println(maxProduct);

		sc.close();
	}

	static int[] buildClosests(int[] a, int[] indices) {
		int[] closests = new int[a.length];
		Stack<Integer> indexStack = new Stack<Integer>();
		for (int index : indices) {
			while (!indexStack.empty() && a[index] >= a[indexStack.peek()]) {
				indexStack.pop();
			}

			closests[index] = indexStack.empty() ? 0 : (indexStack.peek() + 1);

			indexStack.push(index);
		}
		return closests;
	}
}
