import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		long total = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();

			total += (b - a + 1L) * k;
		}
		System.out.println(total / N);

		sc.close();
	}
}
