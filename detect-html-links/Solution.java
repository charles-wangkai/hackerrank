import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern
			.compile("<a [^<>]*href=\"(.*?)\"[^<>]*>((<[^<>]+>)*?([^<>]*)(</[^<>]+>)*?)</a>", Pattern.MULTILINE);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String html = readHtml(sc, N);

		Matcher matcher = PATTERN.matcher(html);
		while (matcher.find()) {
			String link = matcher.group(1).trim();
			String textName = matcher.group(4).trim();
			System.out.println(link + "," + textName);
		}

		sc.close();
	}

	static String readHtml(Scanner sc, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(sc.nextLine());
		}
		return sb.toString();
	}
}
