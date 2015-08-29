import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int T = in.nextInt();
		int[] width = new int[N];
		for (int i = 0; i < width.length; i++) {
			width[i] = in.nextInt();
		}
		for (int tc = 0; tc < T; tc++) {
			int i = in.nextInt();
			int j = in.nextInt();
			System.out.println(min(width, i, j));
		}

		in.close();
	}

	static int min(int[] a, int beginIndex, int endIndex) {
		int result = Integer.MAX_VALUE;
		for (int i = beginIndex; i <= endIndex; i++) {
			result = Math.min(result, a[i]);
		}
		return result;
	}
}
