import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("<\\s*(\\w+)[^<>]*>", Pattern.MULTILINE);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String html = readHtml(sc, N);

		SortedSet<String> tags = new TreeSet<String>();
		Matcher matcher = PATTERN.matcher(html);
		while (matcher.find()) {
			String tag = matcher.group(1);
			tags.add(tag);
		}
		System.out.println(String.join(";", tags.toArray(new String[0])));

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
