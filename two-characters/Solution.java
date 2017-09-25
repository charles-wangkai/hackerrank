import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		Set<Integer> letters = s.chars().collect(HashSet::new, Set::add, Set::addAll);
		int maxLength = 0;
		for (int letter1 : letters) {
			for (int letter2 : letters) {
				if (letter2 == letter1) {
					continue;
				}

				List<Integer> remains = s.chars().filter(ch -> ch == letter1 || ch == letter2).collect(ArrayList::new,
						List::add, List::addAll);

				if (IntStream.range(0, remains.size())
						.allMatch(i -> remains.get(i) == (i % 2 == 0 ? letter1 : letter2))) {
					maxLength = Math.max(maxLength, remains.size());
				}
			}
		}
		return maxLength;
	}
}
