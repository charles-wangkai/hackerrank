import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}

		int negativeCount = 0;
		for (int i = 0; i < numbers.length; i++) {
			int sum = 0;
			for (int j = i; j < numbers.length; j++) {
				sum += numbers[j];
				if (sum < 0) {
					negativeCount++;
				}
			}
		}
		System.out.println(negativeCount);

		in.close();
	}
}
