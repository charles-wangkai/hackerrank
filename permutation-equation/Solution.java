import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt() - 1;
		}
		Arrays.stream(solve(p)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(int[] p) {
		int[] result = new int[p.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0;; j++) {
				if (p[p[j]] == i) {
					result[i] = j + 1;
					break;
				}
			}
		}
		return result;
	}
}
