import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] counts = new int[100];
		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();
			sc.next();
			counts[number]++;
		}

		int L = 0;
		boolean first = true;
		for (int count : counts) {
			if (first) {
				first = false;
			} else {
				System.out.print(" ");
			}

			L += count;
			System.out.print(L);
		}

		sc.close();
	}
}
