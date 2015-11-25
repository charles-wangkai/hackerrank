import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(<|</)[^<>/]+>");

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			Matcher matcher = pattern.matcher(line);
			int index = 0;
			List<String> contents = new ArrayList<String>();
			Stack<String> tagStack = new Stack<String>();
			String content = null;
			boolean lastStartOrEnd = false;
			while (matcher.find()) {
				String tag = matcher.group();

				boolean startOrEnd;
				String tagName;
				if (tag.startsWith("</")) {
					startOrEnd = false;
					tagName = tag.substring(2, tag.length() - 1);
				} else {
					startOrEnd = true;
					tagName = tag.substring(1, tag.length() - 1);
				}

				if (startOrEnd) {
					tagStack.push(tagName);
				} else {
					if (!tagStack.empty() && tagStack.pop().equals(tagName)) {
						if (lastStartOrEnd) {
							content = line.substring(index, matcher.start());
							if (!content.isEmpty()) {
								contents.add(content);
							}
						}
					}
				}

				index = matcher.end();
				lastStartOrEnd = startOrEnd;
			}

			System.out.println(contents.isEmpty() ? "None" : String.join("\n", contents));
		}

		sc.close();
	}
}
