import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String ampmFormat = in.next();
		int hour = Integer.parseInt(ampmFormat.substring(0, 2));
		int minute = Integer.parseInt(ampmFormat.substring(3, 5));
		int second = Integer.parseInt(ampmFormat.substring(6, 8));
		String ampm = ampmFormat.substring(8);

		if (ampm.equals("AM")) {
			if (hour == 12) {
				hour = 0;
			}
		} else {
			if (hour != 12) {
				hour += 12;
			}
		}
		System.out.printf("%02d:%02d:%02d", hour, minute, second);

		in.close();
	}
}
