import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> partialToCount = new HashMap<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String operation = sc.next();
			if (operation.equals("add")) {
				String name = sc.next();
				for (int prefixLength = 1; prefixLength <= name.length(); prefixLength++) {
					String partial = name.substring(0, prefixLength);
					partialToCount.put(partial, partialToCount.getOrDefault(partial, 0) + 1);
				}
			} else if (operation.equals("find")) {
				String partial = sc.next();
				System.out.println(partialToCount.getOrDefault(partial, 0));
			}
		}

		sc.close();
	}
}
