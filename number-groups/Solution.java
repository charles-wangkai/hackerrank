import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		System.out.println(solve(k));

		sc.close();
	}

	static long solve(int k) {
		return (long) k * k * k;
	}
}
