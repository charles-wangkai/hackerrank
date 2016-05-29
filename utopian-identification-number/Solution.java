import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("^\\p{Lower}{0,3}\\d{2,8}\\p{Upper}{3,}$");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			System.out.println(PATTERN.matcher(line).matches() ? "VALID" : "INVALID");
		}

		sc.close();
	}
}
