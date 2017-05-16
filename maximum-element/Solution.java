import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Element> elements = new Stack<Element>();
		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			int type = sc.nextInt();

			if (type == 1) {
				int x = sc.nextInt();
				elements.push(new Element(x, Math.max(elements.empty() ? Integer.MIN_VALUE : elements.peek().max, x)));
			} else if (type == 2) {
				elements.pop();
			} else {
				System.out.println(elements.peek().max);
			}
		}

		sc.close();
	}
}

class Element {
	int x;
	int max;

	Element(int x, int max) {
		this.x = x;
		this.max = max;
	}
}