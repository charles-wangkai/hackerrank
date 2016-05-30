import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String text = readText(sc, N);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String w = sc.next();
			String regex = w + "|" + (w.substring(0, w.length() - 2) + "se");

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(text);
			int result = 0;
			while (matcher.find()) {
				result++;
			}
			System.out.println(result);
		}

		sc.close();
	}

	static String readText(Scanner sc, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}
}
