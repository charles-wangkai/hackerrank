import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] numbers = new String[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.next();
		}

		Arrays.sort(numbers, (n1, n2) -> {
			if (n1.length() != n2.length()) {
				return Integer.compare(n1.length(), n2.length());
			} else {
				for (int i = 0; i < n1.length(); i++) {
					int digit1 = n1.charAt(i) - '0';
					int digit2 = n2.charAt(i) - '0';
					if (digit1 != digit2) {
						return Integer.compare(digit1, digit2);
					}
				}
				return 0;
			}
		});

		Arrays.stream(numbers).forEach(System.out::println);

		sc.close();
	}
}
