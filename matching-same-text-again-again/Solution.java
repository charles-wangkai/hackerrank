import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		Regex_Test tester = new Regex_Test();
		tester.checker(
				"^([a-z])(\\w)(\\s)(\\W)(\\d)(\\D)([A-Z])(\\p{Alpha})([aeiouAEIOU])(\\S)\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10$"); // Use
		// \\
		// instead
		// of
		// using
		// \

	}
}

class Regex_Test {

	public void checker(String Regex_Pattern) {

		Scanner Input = new Scanner(System.in);
		String Test_String = Input.nextLine();
		Pattern p = Pattern.compile(Regex_Pattern);
		Matcher m = p.matcher(Test_String);
		System.out.println(m.find());

		Input.close();
	}

}