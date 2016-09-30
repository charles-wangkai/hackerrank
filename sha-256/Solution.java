import java.security.MessageDigest;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		for (byte oneByte : MessageDigest.getInstance("SHA-256").digest(S.getBytes())) {
			System.out.printf("%02x", oneByte);
		}
		System.out.println();

		sc.close();
	}

	static String padZeros(int size, String str) {
		return repeat('0', size - str.length()) + str;
	}

	static String repeat(char ch, int number) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(ch);
		}
		return sb.toString();
	}
}
