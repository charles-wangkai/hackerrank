import java.util.Scanner;

public class Solution {
	static final String REGEX = "^[_.]\\d+\\p{Alpha}*_?$";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String username = sc.nextLine();

			System.out.println(isValid(username) ? "VALID" : "INVALID");
		}

		sc.close();
	}

	static boolean isValid(String username) {
		return username.matches(REGEX);
	}
}
