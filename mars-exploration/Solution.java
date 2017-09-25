import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		System.out.println(solve(S));

		sc.close();
	}

	static int solve(String S) {
		return IntStream.range(0, S.length() / 3).map(i -> diff(S.substring(i * 3, i * 3 + 3))).sum();
	}

	static int diff(String part) {
		final String UNIT = "SOS";
		return (int) IntStream.range(0, UNIT.length()).filter(i -> part.charAt(i) != UNIT.charAt(i)).count();
	}
}
