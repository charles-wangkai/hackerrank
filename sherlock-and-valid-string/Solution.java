import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : s.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}

		SortedMap<Integer, Integer> countToTimes = new TreeMap<>();
		for (int count : letterToCount.values()) {
			countToTimes.put(count, countToTimes.getOrDefault(count, 0) + 1);
		}

		return countToTimes.size() == 1
				|| (countToTimes.size() == 2 && ((countToTimes.firstKey() + 1 == countToTimes.lastKey()
						&& countToTimes.get(countToTimes.lastKey()) == 1)
						|| (countToTimes.firstKey() == 1 && countToTimes.get(countToTimes.firstKey()) == 1)));
	}
}
