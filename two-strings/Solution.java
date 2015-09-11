import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String A = in.next();
			String B = in.next();
			System.out.println(hasCommon(A, B) ? "YES" : "NO");
		}

		in.close();
	}

	static boolean hasCommon(String A, String B) {
		Set<Integer> lettersA = buildLetters(A);
		Set<Integer> lettersB = buildLetters(B);

		for (int letterA : lettersA) {
			if (lettersB.contains(letterA)) {
				return true;
			}
		}
		return false;
	}

	static Set<Integer> buildLetters(String str) {
		return str.chars().collect(HashSet<Integer>::new, Set::add, Set::addAll);
	}
}
