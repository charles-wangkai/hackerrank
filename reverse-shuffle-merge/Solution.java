import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String S = in.next();
		System.out.println(solve(S));

		in.close();
	}

	static String solve(String S) {
		Map<Character, Integer> remainedLetter2count = buildLetter2count(S);
		Map<Character, Integer> neededLetter2count = halve(remainedLetter2count);

		SortedMap<Character, Queue<Integer>> letter2indices = new TreeMap<Character, Queue<Integer>>();
		int left = S.length();
		int right = S.length() - 1;
		StringBuilder result = new StringBuilder();
		while (result.length() * 2 < S.length()) {
			while (left == S.length()
					|| remainedLetter2count.get(S.charAt(left)) > neededLetter2count.get(S.charAt(left))) {
				if (left < S.length()) {
					remainedLetter2count.put(S.charAt(left), remainedLetter2count.get(S.charAt(left)) - 1);
				}

				left--;

				char letter = S.charAt(left);
				if (neededLetter2count.get(letter) > 0) {
					if (!letter2indices.containsKey(letter)) {
						letter2indices.put(letter, new LinkedList<Integer>());
					}
					letter2indices.get(letter).offer(left);
				}
			}

			char chosen = letter2indices.firstKey();
			result.append(chosen);

			neededLetter2count.put(chosen, neededLetter2count.get(chosen) - 1);

			int chosenIndex = letter2indices.get(chosen).peek();
			while (right >= chosenIndex) {
				char letter = S.charAt(right);
				if (letter2indices.containsKey(letter)) {
					letter2indices.get(letter).poll();
					if (letter2indices.get(letter).isEmpty()) {
						letter2indices.remove(letter);
					}
				}

				right--;
			}
			if (neededLetter2count.get(chosen) == 0 && letter2indices.containsKey(chosen)) {
				letter2indices.remove(chosen);
			}
		}
		return result.toString();
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

	static Map<Character, Integer> halve(Map<Character, Integer> letter2count) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for (Entry<Character, Integer> entry : letter2count.entrySet()) {
			result.put(entry.getKey(), entry.getValue() / 2);
		}
		return result;
	}
}
