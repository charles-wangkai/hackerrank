import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		long n = sc.nextLong();
		System.out.println(solve(s, n));

		sc.close();
	}

	static long solve(String s, long n) {
		return n / s.length() * count(s, 'a') + count(s.substring(0, (int) (n % s.length())), 'a');
	}

	static int count(String s, char target) {
		return (int) s.chars().filter(c -> c == target).count();
	}
}
