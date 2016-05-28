import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("https?://(www.|ww2.)?([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+)");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String html = readHtml(sc, N);

		SortedSet<String> domainNames = new TreeSet<String>();
		Matcher matcher = PATTERN.matcher(html);
		while (matcher.find()) {
			String domainName = matcher.group(2);
			domainNames.add(domainName);
		}
		System.out.println(String.join(";", domainNames.stream().collect(Collectors.toList())));

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
