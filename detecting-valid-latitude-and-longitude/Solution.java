import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile(
			"\\([+-]?(90(\\.0+)?|([1-8][0-9]|[1-9])(\\.\\d+)?), [+-]?(180(\\.0+)?|(1[0-7][0-9]|[1-9][0-9]|[1-9])(\\.\\d+)?)\\)");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			System.out.println(PATTERN.matcher(line).matches() ? "Valid" : "Invalid");
		}

		sc.close();
	}
}
