import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<Character, Integer> letter2countA = buildLetter2count(in.next());
		Map<Character, Integer> letter2countB = buildLetter2count(in.next());
		System.out.println(diff(letter2countA, letter2countB));

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

	static int diff(Map<Character, Integer> letter2countA, Map<Character, Integer> letter2countB) {
		int result = 0;
		for (char letterA : letter2countA.keySet()) {
			if (letter2countB.containsKey(letterA)) {
				result += Math.abs(letter2countA.get(letterA) - letter2countB.get(letterA));
			} else {
				result += letter2countA.get(letterA);
			}
		}
		for (char letterB : letter2countB.keySet()) {
			if (!letter2countA.containsKey(letterB)) {
				result += letter2countB.get(letterB);
			}
		}
		return result;
	}
}
