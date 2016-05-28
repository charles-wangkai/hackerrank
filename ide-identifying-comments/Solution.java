import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String code = readCode(sc);

		Matcher matcher = PATTERN.matcher(code);
		while (matcher.find()) {
			String comment = matcher.group();
			display(comment);
		}

		sc.close();
	}

	static String readCode(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}

	static void display(String comment) {
		Scanner sc = new Scanner(comment);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine().trim());
		}

		sc.close();
	}
}
