import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int actualDay = sc.nextInt();
		int actualMonth = sc.nextInt();
		int actualYear = sc.nextInt();
		int expectedDay = sc.nextInt();
		int expectedMonth = sc.nextInt();
		int expectedYear = sc.nextInt();
		System.out.println(solve(actualDay, actualMonth, actualYear, expectedDay, expectedMonth, expectedYear));

		sc.close();
	}

	static int solve(int actualDay, int actualMonth, int actualYear, int expectedDay, int expectedMonth,
			int expectedYear) {
		if (actualYear < expectedYear) {
			return 0;
		} else if (actualYear > expectedYear) {
			return 10000;
		} else {
			if (actualMonth < expectedMonth) {
				return 0;
			} else if (actualMonth > expectedMonth) {
				return 500 * (actualMonth - expectedMonth);
			} else {
				if (actualDay <= expectedDay) {
					return 0;
				} else {
					return 15 * (actualDay - expectedDay);
				}
			}
		}
	}
}
