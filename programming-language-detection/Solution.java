import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String code = readCode(sc);

		if (Pattern.compile("^\\s*#include", Pattern.MULTILINE).matcher(code).find()) {
			System.out.println("C");
		} else if (Pattern.compile("^\\s*import java\\.", Pattern.MULTILINE).matcher(code).find()) {
			System.out.println("Java");
		} else {
			System.out.println("Python");
		}

		sc.close();
	}

	static String readCode(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}
}
