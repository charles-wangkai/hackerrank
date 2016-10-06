import java.security.MessageDigest;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		for (byte oneByte : MessageDigest.getInstance("MD5").digest(S.getBytes())) {
			System.out.printf("%02x", oneByte);
		}
		System.out.println();

		sc.close();
	}
}
