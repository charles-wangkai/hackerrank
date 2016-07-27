import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a[] = readTriplet(sc);
		int b[] = readTriplet(sc);

		int scoreA = 0;
		int scoreB = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b[i]) {
				scoreA++;
			} else if (a[i] < b[i]) {
				scoreB++;
			}
		}
		System.out.println(scoreA + " " + scoreB);

		sc.close();
	}

	static int[] readTriplet(Scanner sc) {
		int[] x = new int[3];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		return x;
	}
}
