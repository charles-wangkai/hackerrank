import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c, k));

		sc.close();
	}

	static int solve(int[] c, int k) {
		int E = 100;
		int index = 0;
		do {
			index = (index + k) % c.length;
			E--;

			if (c[index] == 1) {
				E -= 2;
			}
		} while (index != 0);
		return E;
	}
}
