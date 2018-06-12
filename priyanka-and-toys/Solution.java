import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}

		System.out.println(solve(w));

		sc.close();
	}

	static int solve(int[] w) {
		Arrays.sort(w);

		int containerNum = 0;
		int limit = -1;
		for (int weight : w) {
			if (weight > limit) {
				containerNum++;
				limit = weight + 4;
			}
		}
		return containerNum;
	}
}
