import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String sentences = readLines(sc, N);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String substring = sc.next();

			System.out.println(findOccurrenceNum(sentences, substring));
		}

		sc.close();
	}

	static String readLines(Scanner sc, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}

	static int findOccurrenceNum(String sentences, String substring) {
		int occurrenceNum = 0;
		Pattern pattern = Pattern.compile("\\w" + substring + "\\w");
		Matcher matcher = pattern.matcher(sentences);
		while (matcher.find()) {
			occurrenceNum++;
		}
		return occurrenceNum;
	}
}
