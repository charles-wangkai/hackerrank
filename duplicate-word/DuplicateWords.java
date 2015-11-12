import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		String pattern = "(?<!\\w)(\\w+)( \\1)*(?!\\w)";
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String input = in.nextLine();
			Matcher m = r.matcher(input);
			boolean findMatch = true;
			while (m.find()) {
				input = input.replaceAll(String.format("(?<!\\w)%s(?!\\w)", m.group()), m.group(1));
				findMatch = false;
			}
			System.out.println(input);
			testCases--;
		}
	}
}
