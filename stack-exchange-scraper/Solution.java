import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile(
			"id=\"question-summary-(\\d+)\".*?class=\"question-hyperlink\">(.+?)</a>.*?class=\"relativetime\">(.+?)</span>");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String html = readHtml(sc);
		Matcher matcher = PATTERN.matcher(html);
		while (matcher.find()) {
			String id = matcher.group(1).trim();
			String question = matcher.group(2).trim();
			String time = matcher.group(3).trim();

			System.out.println(String.join(";", id, question, time));
		}

		sc.close();
	}

	static String readHtml(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
		}
		return sb.toString();
	}
}
