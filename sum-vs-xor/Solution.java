import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		if (n == 0) {
			return 1;
		}

		return 1L << Long.toBinaryString(n).chars().filter(ch -> ch == '0').count();
	}
}
