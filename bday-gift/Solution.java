import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.printf("%.1f\n", solve(numbers));

		sc.close();
	}

	static double solve(int[] numbers) {
		return Arrays.stream(numbers).asLongStream().sum() / 2.0;
	}
}
