import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static final Pattern PATTERN = Pattern.compile(
			"\\d{5}\\s(C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String line = sc.nextLine();

			System.out.println(PATTERN.matcher(line).matches() ? "VALID" : "INVALID");
		}

		sc.close();
	}
}
