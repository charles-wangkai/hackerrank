import java.util.Scanner;

public class Solution {
	static final String IPV4_REGEX = "^((\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])$";
	static final String IPV6_REGEX = "^([0-9a-f]{1,4}:){7}[0-9a-f]{1,4}$";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			if (isIPv4(line)) {
				System.out.println("IPv4");
			} else if (isIPv6(line)) {
				System.out.println("IPv6");
			} else {
				System.out.println("Neither");
			}
		}

		sc.close();
	}

	static boolean isIPv4(String s) {
		return s.matches(IPV4_REGEX);
	}

	static boolean isIPv6(String s) {
		return s.matches(IPV6_REGEX);
	}
}
