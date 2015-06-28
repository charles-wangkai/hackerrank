import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		String[] words = str.split("[^A-Za-z]+");
		if (words.length > 0 && words[0].isEmpty()) {
			words = Arrays.copyOfRange(words, 1, words.length);
		}

		System.out.println(words.length);
		for (String word : words) {
			System.out.println(word);
		}

		in.close();
	}
}
