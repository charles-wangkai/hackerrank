import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n + 1];
		for (int x = 1; x <= n; x++) {
			f[x] = sc.nextInt();
		}

		boolean involution = true;
		for (int x = 1; x <= n; x++) {
			if (f[f[x]] != x) {
				involution = false;
				break;
			}
		}
		System.out.println(involution ? "YES" : "NO");

		sc.close();
	}
}
