import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern START_PATTERN = Pattern.compile("^hackerrank");
	static final Pattern END_PATTERN = Pattern.compile("hackerrank$");
	static final Pattern START_END_PATTERN = Pattern.compile("^hackerrank$");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			if (START_END_PATTERN.matcher(line).find()) {
				System.out.println(0);
			} else if (START_PATTERN.matcher(line).find()) {
				System.out.println(1);
			} else if (END_PATTERN.matcher(line).find()) {
				System.out.println(2);
			} else {
				System.out.println(-1);
			}
		}

		sc.close();
	}
}
