import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = sc.nextInt();
		}
		System.out.println(solve(heights));

		sc.close();
	}

	static int solve(int[] heights) {
		int maxHeight = Arrays.stream(heights).max().getAsInt();
		return (int) Arrays.stream(heights).filter(height -> height == maxHeight).count();
	}
}
