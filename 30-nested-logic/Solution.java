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

		int fine;
		if (actualYear > expectedYear) {
			fine = 10000;
		} else if (actualYear < expectedYear) {
			fine = 0;
		} else if (actualMonth > expectedMonth) {
			fine = 500 * (actualMonth - expectedMonth);
		} else if (actualMonth < expectedMonth) {
			fine = 0;
		} else if (actualDay > expectedDay) {
			fine = 15 * (actualDay - expectedDay);
		} else {
			fine = 0;
		}
		System.out.println(fine);

		sc.close();
	}
}
