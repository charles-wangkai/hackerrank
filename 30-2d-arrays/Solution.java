import java.util.Scanner;

public class Solution {
	static final int SIZE = 6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] A = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int maxHourglassSum = Integer.MIN_VALUE;
		for (int i = 0; i < SIZE - 2; i++) {
			for (int j = 0; j < SIZE - 2; j++) {
				int hourglassSum = A[i][j] + A[i][j + 1] + A[i][j + 2] + A[i + 1][j + 1] + A[i + 2][j] + A[i + 2][j + 1]
						+ A[i + 2][j + 2];
				maxHourglassSum = Math.max(maxHourglassSum, hourglassSum);
			}
		}
		System.out.println(maxHourglassSum);

		sc.close();
	}
}
