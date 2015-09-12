import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String S = in.next();
			System.out.println(findUnorderedAnagramPairNum(S));
		}

		in.close();
	}

	static int findUnorderedAnagramPairNum(String str) {
		Map<String, Integer> key2count = new HashMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String key = generateKey(str.substring(i, j));
				if (!key2count.containsKey(key)) {
					key2count.put(key, 0);
				}
				key2count.put(key, key2count.get(key) + 1);
			}
		}
		return key2count.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
	}

	static String generateKey(String str) {
		return str.chars().sorted().mapToObj(letter -> (char) letter)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
