import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = in.next();
			System.out.println(Math.min(countDeletion(str, 'A'), countDeletion(str, 'B')));
		}

		in.close();
	}

	static int countDeletion(String str, char target) {
		int deletionNum = 0;
		boolean match = true;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == target) == match) {
				match = !match;
			} else {
				deletionNum++;
			}
		}
		return deletionNum;
	}
}
