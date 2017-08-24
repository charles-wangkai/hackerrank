import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] rotated = rotate(a, d);
		for (int i = 0; i < rotated.length; i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(rotated[i]);
		}
		System.out.println();

		sc.close();
	}

	static int[] rotate(int[] a, int d) {
		int[] rotated = new int[a.length];
		for (int i = 0; i < rotated.length; i++) {
			rotated[i] = a[(i + d) % a.length];
		}
		return rotated;
	}
}
