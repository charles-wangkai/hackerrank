import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static long solve(int n, int m) {
		return (long) (n - 1) * (m - 1) + (n - 1) + (m - 1);
	}
}
