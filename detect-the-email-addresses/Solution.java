import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String text = readText(sc, N);

		SortedSet<String> emails = new TreeSet<String>();
		Matcher matcher = PATTERN.matcher(text);
		while (matcher.find()) {
			String email = matcher.group();
			emails.add(email);
		}
		System.out.println(String.join(";", emails.stream().collect(Collectors.toList())));

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
