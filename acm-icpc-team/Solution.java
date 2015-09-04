import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		in.nextInt();
		String[] lines = new String[N];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = in.next();
		}

		int maxTopic = 0;
		int count = 0;
		for (int i = 0; i < lines.length; i++) {
			for (int j = i + 1; j < lines.length; j++) {
				String merged = merge(lines[i], lines[j]);
				int topic = (int) merged.chars().filter(x -> x == '1').count();
				if (topic > maxTopic) {
					maxTopic = topic;
					count = 1;
				} else if (topic == maxTopic) {
					count++;
				}
			}
		}
		System.out.println(maxTopic);
		System.out.println(count);

		in.close();
	}

	static String merge(String line1, String line2) {
		StringBuilder merged = new StringBuilder();
		for (int i = 0; i < line1.length(); i++) {
			if (line1.charAt(i) == '1' || line2.charAt(i) == '1') {
				merged.append('1');
			} else {
				merged.append('0');
			}
		}
		return merged.toString();
	}
}
