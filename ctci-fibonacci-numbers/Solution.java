import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(fibonacci(n));

		sc.close();
	}

	static int fibonacci(int n) {
		int prevprev = 0;
		int prev = 1;
		for (int i = 0; i < n - 1; i++) {
			int current = prevprev + prev;
			prevprev = prev;
			prev = current;
		}
		return prev;
	}
}
