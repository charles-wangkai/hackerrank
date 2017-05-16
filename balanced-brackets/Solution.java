import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String s = sc.next();
			System.out.println(solve(s) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s) {
		Stack<Character> brackets = new Stack<Character>();
		for (char bracket : s.toCharArray()) {
			if (bracket == '(' || bracket == '[' || bracket == '{') {
				brackets.push(bracket);
			} else {
				if ((bracket == ')' && !(!brackets.empty() && brackets.peek() == '('))
						|| (bracket == ']' && !(!brackets.empty() && brackets.peek() == '['))
						|| (bracket == '}' && !(!brackets.empty() && brackets.peek() == '{'))) {
					return false;
				}
				brackets.pop();
			}
		}
		return brackets.empty();
	}
}
