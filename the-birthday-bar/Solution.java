import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		int d = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(s, d, m));

		sc.close();
	}

	static int solve(int[] s, int d, int m) {
		if (m > s.length) {
			return 0;
		}

		int sum = IntStream.range(0, m).map(i -> s[i]).sum();
		int result = 0;
		for (int i = 0; i + m <= s.length; i++) {
			if (sum == d) {
				result++;
			}

			if (i + m < s.length) {
				sum += s[i + m] - s[i];
			}
		}
		return result;
	}
}
