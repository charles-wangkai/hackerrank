import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = sc.nextInt();
		}
		System.out.println(solve(k, heights));

		sc.close();
	}

	static int solve(int k, int[] heights) {
		return Math.max(0, Arrays.stream(heights).max().getAsInt() - k);
	}
}
