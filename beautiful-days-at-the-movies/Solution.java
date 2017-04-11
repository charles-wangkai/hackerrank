import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(i, j, k));

		sc.close();
	}

	static int solve(int i, int j, int k) {
		return (int) IntStream.rangeClosed(i, j).filter(x -> Math.abs(x - reverse(x)) % k == 0).count();
	}

	static int reverse(int x) {
		return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
	}
}
