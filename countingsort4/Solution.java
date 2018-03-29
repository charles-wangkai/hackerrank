import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		@SuppressWarnings("unchecked")
		List<String>[] sLists = new List[100];
		for (int i = 0; i < sLists.length; i++) {
			sLists[i] = new ArrayList<String>();
		}

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			String s = sc.next();

			sLists[x].add((i < n / 2) ? "-" : s);
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sLists.length; i++) {
			for (String s : sLists[i]) {
				if (result.length() != 0) {
					result.append(" ");
				}
				result.append(s);
			}
		}
		System.out.println(result);

		sc.close();
	}
}
