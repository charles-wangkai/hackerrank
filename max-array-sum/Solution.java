import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr));

		sc.close();
	}

	static int solve(int[] arr) {
		int result = 0;
		int useSum = 0;
		int notUseSum = 0;
		for (int number : arr) {
			result = Math.max(result, notUseSum + number);

			int nextUseSum = notUseSum + number;
			int nextNotUseSum = Math.max(useSum, notUseSum);

			useSum = nextUseSum;
			notUseSum = nextNotUseSum;
		}
		return result;
	}
}
