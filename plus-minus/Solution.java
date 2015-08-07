import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int positiveNum = 0;
		int negativeNum = 0;
		int zeroNum = 0;
		for (int i = 0; i < N; i++) {
			int number = in.nextInt();
			if (number > 0) {
				positiveNum++;
			} else if (number < 0) {
				negativeNum++;
			} else {
				zeroNum++;
			}
		}
		System.out.printf("%.3f\n", (double) positiveNum / N);
		System.out.printf("%.3f\n", (double) negativeNum / N);
		System.out.printf("%.3f\n", (double) zeroNum / N);

		in.close();
	}
}
