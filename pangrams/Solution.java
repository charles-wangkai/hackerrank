import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		System.out.println(isPangram(s) ? "pangram" : "not pangram");

		in.close();
	}

	static boolean isPangram(String str) {
		return str.toLowerCase().chars().filter(letter -> Character.isLetter(letter))
				.collect(HashSet<Integer>::new, Set::add, Set::addAll).size() == 26;
	}
}
