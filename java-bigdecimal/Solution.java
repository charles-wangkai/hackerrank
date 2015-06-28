import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String[] numbers = new String[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.next();
		}

		Arrays.sort(numbers, (number1, number2) -> new BigDecimal(number2)
				.compareTo(new BigDecimal(number1)));

		for (String number : numbers) {
			System.out.println(number);
		}

		in.close();
	}
}
