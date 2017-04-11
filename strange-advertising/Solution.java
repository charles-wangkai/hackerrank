import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int receive = 5;
		int likeTotal = 0;
		for (int i = 0; i < n; i++) {
			int like = receive / 2;
			likeTotal += like;

			receive = like * 3;
		}
		return likeTotal;
	}
}
