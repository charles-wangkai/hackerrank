import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StackBasedQueue<Integer> queue = new StackBasedQueue<>();
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int type = sc.nextInt();

			if (type == 1) {
				int x = sc.nextInt();
				queue.enqueue(x);
			} else if (type == 2) {
				queue.dequeue();
			} else {
				System.out.println(queue.peek());
			}
		}

		sc.close();
	}
}

class StackBasedQueue<T> {
	private Stack<T> inStack = new Stack<>();
	private Stack<T> outStack = new Stack<>();

	public void enqueue(T element) {
		inStack.push(element);
	}

	public void dequeue() {
		if (outStack.empty()) {
			fillOutStack();
		}

		outStack.pop();
	}

	public T peek() {
		if (outStack.empty()) {
			fillOutStack();
		}

		return outStack.peek();
	}

	private void fillOutStack() {
		while (!inStack.empty()) {
			outStack.push(inStack.pop());
		}
	}
}