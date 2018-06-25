import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] machines = new int[n];
		for (int i = 0; i < machines.length; i++) {
			machines[i] = sc.nextInt();
		}
		System.out.println(solve(machines, goal));

		sc.close();
	}

	static long solve(int[] machines, int goal) {
		long result = -1;
		long lower = 0;
		long upper = 1000000000000000000L;
		while (lower <= upper) {
			long middle = (lower + upper) / 2;
			if (computeItemNum(machines, middle) >= goal) {
				result = middle;

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
		return result;
	}

	static int computeItemNum(int[] machines, long days) {
		long itemNumber = 0;
		for (int machine : machines) {
			itemNumber += days / machine;

			if (itemNumber > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
		}
		return (int) itemNumber;
	}
}
