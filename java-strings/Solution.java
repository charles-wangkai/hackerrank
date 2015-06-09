import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int k = in.nextInt();

		List<String> substrings = new ArrayList<String>();
		for (int i = 0; i + k <= str.length(); i++) {
			substrings.add(str.substring(i, i + k));
		}
		Collections.sort(substrings);
		System.out.println(substrings.get(0));
		System.out.println(substrings.get(substrings.size() - 1));

		in.close();
	}
}
