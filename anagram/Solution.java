import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = in.next();
			if (str.length() % 2 == 0) {
				int halfLength = str.length() / 2;
				String s1 = str.substring(0, halfLength);
				String s2 = str.substring(halfLength);
				Map<Character, Integer> letter2count1 = buildLetter2count(s1);
				Map<Character, Integer> letter2count2 = buildLetter2count(s2);
				System.out.println(diff(letter2count1, letter2count2) / 2);
			} else {
				System.out.println(-1);
			}
		}

		in.close();
	}

	static Map<Character, Integer> buildLetter2count(String str) {
		Map<Character, Integer> letter2count = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (!letter2count.containsKey(letter)) {
				letter2count.put(letter, 0);
			}
			letter2count.put(letter, letter2count.get(letter) + 1);
		}
		return letter2count;
	}

	static int diff(Map<Character, Integer> letter2count1, Map<Character, Integer> letter2count2) {
		int result = 0;
		for (char letterA : letter2count1.keySet()) {
			if (letter2count2.containsKey(letterA)) {
				result += Math.abs(letter2count1.get(letterA) - letter2count2.get(letterA));
			} else {
				result += letter2count1.get(letterA);
			}
		}
		for (char letterB : letter2count2.keySet()) {
			if (!letter2count1.containsKey(letterB)) {
				result += letter2count2.get(letterB);
			}
		}
		return result;
	}
}
