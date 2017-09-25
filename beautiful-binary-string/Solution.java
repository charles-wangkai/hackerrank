import java.util.Scanner;

public class Solution {
	static final String FROM = "010";
	static final String TO = "011";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String B = sc.next();
		System.out.println(solve(B));

		sc.close();
	}

	static int solve(String B) {
		int step = 0;
		while (B.contains(FROM)) {
			B = B.replaceFirst(FROM, TO);
			step++;
		}
		return step;
	}
}
