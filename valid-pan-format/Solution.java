import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile("^\\p{Upper}{5}\\d{4}\\p{Upper}$");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			String pan = sc.next();

			System.out.println(PATTERN.matcher(pan).matches() ? "YES" : "NO");
		}

		sc.close();
	}
}
