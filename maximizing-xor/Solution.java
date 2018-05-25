import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();

		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int l, int r) {
		return IntStream.rangeClosed(l, r).flatMap(a -> IntStream.rangeClosed(a, r).map(b -> a ^ b)).max().getAsInt();
	}
}
