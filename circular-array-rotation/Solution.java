import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < q; i++) {
			int m = sc.nextInt();
			System.out.println(a[((m - k) % n + n) % n]);
		}

		sc.close();
	}
}
