import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern TAG_PATTERN = Pattern.compile("<\\s*(\\w+)[^<>]*>");

	static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("(\\w+)\\s*=(\".*?\"|'.*?')");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String html = readHtml(sc, N);

		SortedMap<String, SortedSet<String>> tag2attributes = new TreeMap<String, SortedSet<String>>();

		Matcher tagMatcher = TAG_PATTERN.matcher(html);
		while (tagMatcher.find()) {
			String tag = tagMatcher.group();
			String tagName = tagMatcher.group(1);

			if (!tag2attributes.containsKey(tagName)) {
				tag2attributes.put(tagName, new TreeSet<String>());
			}

			Matcher attributeMatcher = ATTRIBUTE_PATTERN.matcher(tag);
			while (attributeMatcher.find()) {
				String attributeName = attributeMatcher.group(1);
				tag2attributes.get(tagName).add(attributeName);
			}
		}

		tag2attributes.keySet()
				.forEach(tagName -> System.out.println(tagName + ":" + String.join(",", tag2attributes.get(tagName))));

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
