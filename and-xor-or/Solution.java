import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		System.out.println(solve(A));

		sc.close();
	}

	static int solve(int[] A) {
		int result = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int number : A) {
			while (!stack.empty()) {
				result = Math.max(result, S(number, stack.peek()));

				if (number < stack.peek()) {
					stack.pop();
				} else {
					break;
				}
			}

			stack.push(number);
		}
		return result;
	}

	static int S(int x, int y) {
		return ((x & y) ^ (x | y)) & (x ^ y);
	}
}
