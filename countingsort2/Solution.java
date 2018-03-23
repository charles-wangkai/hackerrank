import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] counts = new int[100];
		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();
			counts[number]++;
		}

		boolean first = true;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				if (first) {
					first = false;
				} else {
					System.out.print(" ");
				}

				System.out.print(i);
			}
		}

		sc.close();
	}
}
