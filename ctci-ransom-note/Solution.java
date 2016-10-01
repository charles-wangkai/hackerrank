import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		Map<String, Integer> word2countMagazine = buildWord2count(sc, m);
		Map<String, Integer> word2countNote = buildWord2count(sc, n);

		System.out.println(contains(word2countMagazine, word2countNote) ? "Yes" : "No");

		sc.close();
	}

	static boolean contains(Map<String, Integer> word2countMagazine, Map<String, Integer> word2countNote) {
		for (Entry<String, Integer> entryNote : word2countNote.entrySet()) {
			if (!word2countMagazine.containsKey(entryNote.getKey())
					|| word2countMagazine.get(entryNote.getKey()) < entryNote.getValue()) {
				return false;
			}
		}
		return true;
	}

	static Map<String, Integer> buildWord2count(Scanner sc, int wordNum) {
		Map<String, Integer> word2count = new HashMap<String, Integer>();
		for (int i = 0; i < wordNum; i++) {
			String word = sc.next();
			if (!word2count.containsKey(word)) {
				word2count.put(word, 0);
			}
			word2count.put(word, word2count.get(word) + 1);
		}
		return word2count;
	}
}
