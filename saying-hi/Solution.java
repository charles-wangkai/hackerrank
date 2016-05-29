import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("^[Hh][Ii]\\s[^Dd].*$");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < n; tc++) {
			String line = sc.nextLine();

			Matcher matcher = PATTERN.matcher(line);
			if (matcher.find()) {
				System.out.println(matcher.group());
			}
		}

		sc.close();
	}
}
