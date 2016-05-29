import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static Pattern PATTERN = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		int result = 0;
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();

			if (PATTERN.matcher(line).find()) {
				result++;
			}
		}
		System.out.println(result);

		sc.close();
	}
}
