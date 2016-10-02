import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = sc.nextInt();
		for (int i = 0; i < n - 1; i++) {
			result ^= sc.nextInt();
		}
		System.out.println(result);

		sc.close();
	}
}
