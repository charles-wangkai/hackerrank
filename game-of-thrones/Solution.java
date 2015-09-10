import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.next();
		System.out.println(isAnagramPalindrome(str) ? "YES" : "NO");

		in.close();
	}

	static boolean isAnagramPalindrome(String str) {
		Map<Character, Integer> letter2count = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (!letter2count.containsKey(letter)) {
				letter2count.put(letter, 0);
			}
			letter2count.put(letter, letter2count.get(letter) + 1);
		}

		return letter2count.values().stream().filter(value -> value % 2 != 0).count() <= 1;
	}
}
