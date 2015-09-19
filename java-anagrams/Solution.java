import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		System.out.println(generateAnagramKey(A).equals(generateAnagramKey(B)) ? "Anagrams" : "Not Anagrams");

		sc.close();
	}

	static String generateAnagramKey(String str) {
		char[] letters = str.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
}
