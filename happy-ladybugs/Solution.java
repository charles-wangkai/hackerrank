import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int g = sc.nextInt();
		for (int tc = 0; tc < g; tc++) {
			sc.nextInt();
			String b = sc.next();
			System.out.println(solve(b) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String b) {
		boolean hasEmpty = false;
		boolean hasUnhappy = false;
		Map<Character, Integer> color2count = new HashMap<Character, Integer>();

		for (int i = 0; i < b.length(); i++) {
			char cell = b.charAt(i);
			if (cell == '_') {
				hasEmpty = true;
			} else {
				if ((i == 0 || b.charAt(i - 1) != cell) && (i == b.length() - 1 || b.charAt(i + 1) != cell)) {
					hasUnhappy = true;
				}

				if (!color2count.containsKey(cell)) {
					color2count.put(cell, 0);
				}
				color2count.put(cell, color2count.get(cell) + 1);
			}
		}

		return !hasUnhappy || (hasEmpty && color2count.values().stream().mapToInt(x -> x).min().getAsInt() >= 2);
	}
}
