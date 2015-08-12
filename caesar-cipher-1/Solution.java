import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		in.nextInt();
		String S = in.next();
		int K = in.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (Character.isLowerCase(ch)) {
				ch = (char) ((ch - 'a' + K) % 26 + 'a');
			} else if (Character.isUpperCase(ch)) {
				ch = (char) ((ch - 'A' + K) % 26 + 'A');
			}
			sb.append(ch);
		}
		System.out.println(sb);

		in.close();
	}
}
