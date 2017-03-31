import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		long sum = Arrays.stream(numbers).mapToLong(x -> x).sum();
		int min = Arrays.stream(numbers).min().getAsInt();
		int max = Arrays.stream(numbers).max().getAsInt();

		System.out.println(String.format("%d %d", sum - max, sum - min));

		sc.close();
	}
}
