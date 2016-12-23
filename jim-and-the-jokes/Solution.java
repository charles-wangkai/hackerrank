import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Integer, Integer> number2count = new HashMap<Integer, Integer>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int month = sc.nextInt();
			int date = sc.nextInt();

			if (isValid(month, date)) {
				int number = convertToNumber(month, date);

				if (!number2count.containsKey(number)) {
					number2count.put(number, 0);
				}
				number2count.put(number, number2count.get(number) + 1);
			}
		}

		long result = 0;
		for (int count : number2count.values()) {
			if (count > 1) {
				result += (long) count * (count - 1) / 2;
			}
		}
		System.out.println(result);

		sc.close();
	}

	static boolean isValid(int month, int date) {
		return month != 1 && String.valueOf(date).chars().allMatch(digit -> digit - '0' < month);
	}

	static int convertToNumber(int month, int date) {
		int number = 0;
		for (char digit : String.valueOf(date).toCharArray()) {
			number = number * month + (digit - '0');
		}
		return number;
	}
}
