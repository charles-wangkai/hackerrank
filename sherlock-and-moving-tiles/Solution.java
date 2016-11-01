import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			long qi = sc.nextLong();

			System.out.println(solve(L, S1, S2, qi));
		}
		sc.close();
	}

	static double solve(int L, int S1, int S2, long qi) {
		return (L * Math.sqrt(2) - Math.sqrt(qi) * Math.sqrt(2)) / Math.abs(S1 - S2);
	}
}
