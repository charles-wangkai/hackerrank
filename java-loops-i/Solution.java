import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.println(String.format("%d x %d = %d", N, i, N * i));
		}

		sc.close();
	}
}
