import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String sentences = readSentences(sc, N);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String word = sc.next();
			System.out.println(findOccurrenceNum(sentences, word));
		}

		sc.close();
	}

	static String readSentences(Scanner sc, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}

	static int findOccurrenceNum(String sentences, String word) {
		Pattern pattern = Pattern.compile("(?<![a-zA-Z0-9_])" + word + "(?![a-zA-Z0-9_])");
		Matcher matcher = pattern.matcher(sentences);
		int occurrenceNum = 0;
		while (matcher.find()) {
			occurrenceNum++;
		}
		return occurrenceNum;
	}
}
