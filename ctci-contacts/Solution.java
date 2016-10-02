import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Trie trie = new Trie();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("add")) {
				String name = sc.next();
				trie.add(name);
			} else if (command.equals("find")) {
				String partial = sc.next();
				System.out.println(trie.count(partial));
			}
		}

		sc.close();
	}
}

class Trie {
	Map<Character, Trie> letter2trie = new HashMap<Character, Trie>();
	int count;

	void add(String s) {
		count++;

		if (!s.isEmpty()) {
			char first = s.charAt(0);
			if (!letter2trie.containsKey(first)) {
				letter2trie.put(first, new Trie());
			}

			letter2trie.get(first).add(s.substring(1));
		}
	}

	int count(String s) {
		if (s.isEmpty()) {
			return count;
		}

		char first = s.charAt(0);
		return letter2trie.containsKey(first) ? letter2trie.get(first).count(s.substring(1)) : 0;
	}
}