import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			a[i] = val;
		}

		// Print all the array elements
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		sc.close();
	}
}
