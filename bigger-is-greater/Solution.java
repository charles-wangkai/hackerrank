import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String w = in.next();
			String next = findNext(w);
			System.out.println((next == null) ? "no answer" : next);
		}

		in.close();
	}

	static String findNext(String word) {
		int index = word.length() - 2;
		while (index >= 0 && word.charAt(index) >= word.charAt(index + 1)) {
			index--;
		}

		if (index < 0) {
			return null;
		}

		int biggerIndex = index + 1;
		while (biggerIndex + 1 < word.length() && word.charAt(biggerIndex + 1) > word.charAt(index)) {
			biggerIndex++;
		}

		StringBuilder next = new StringBuilder(word);
		swap(next, index, biggerIndex);
		reverse(next, index + 1, next.length() - 1);
		return next.toString();
	}

	static void swap(StringBuilder sb, int index1, int index2) {
		char temp = sb.charAt(index1);
		sb.setCharAt(index1, sb.charAt(index2));
		sb.setCharAt(index2, temp);
	}

	static void reverse(StringBuilder sb, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			swap(sb, i, j);
		}
	}
}
