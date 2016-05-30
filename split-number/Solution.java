import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("(\\d{1,3})[- ](\\d{1,3})[- ](\\d{4,10})");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			Matcher matcher = PATTERN.matcher(line);
			matcher.find();
			String countryCode = matcher.group(1);
			String localAreaCode = matcher.group(2);
			String number = matcher.group(3);

			System.out.println(
					String.format("CountryCode=%s,LocalAreaCode=%s,Number=%s", countryCode, localAreaCode, number));
		}

		sc.close();
	}
}
