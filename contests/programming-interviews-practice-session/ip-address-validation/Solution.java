import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		for (int tc = 0; tc < N; tc++) {
			String line = in.nextLine();
			if (isIPv4(line)) {
				System.out.println("IPv4");
			} else if (isIPv6(line)) {
				System.out.println("IPv6");
			} else {
				System.out.println("Neither");
			}
		}

		in.close();
	}

	static boolean isIPv4(String text) {
		String part = "((25[0-5])|(2[0-4][0-9])|([0-1]{0,1}[0-9]{1,2}))";
		String regex = String.format("%s\\.%s\\.%s\\.%s", part, part, part,
				part);
		return text.matches(regex);
	}

	static boolean isIPv6(String text) {
		String part = "[0-9a-f]{1,4}";
		String regex = String.format("%s:%s:%s:%s:%s:%s:%s:%s", part, part,
				part, part, part, part, part, part);
		return text.matches(regex);
	}
}
