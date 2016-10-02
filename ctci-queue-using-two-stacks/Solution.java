import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MyQueue<Integer> queue = new MyQueue<Integer>();

		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int x = sc.nextInt();
				queue.enqueue(x);
			} else if (type == 2) {
				queue.dequeue();
			} else if (type == 3) {
				System.out.println(queue.peek());
			}
		}

		sc.close();
	}
}

class MyQueue<T> {
	Stack<T> leftStack = new Stack<T>();
	Stack<T> rightStack = new Stack<T>();

	void enqueue(T item) {
		leftStack.push(item);
	}

	T dequeue() {
		transferIfNeeded();
		return rightStack.pop();
	}

	T peek() {
		transferIfNeeded();
		return rightStack.peek();
	}

	void transferIfNeeded() {
		if (rightStack.empty()) {
			while (!leftStack.empty()) {
				rightStack.push(leftStack.pop());
			}
		}
	}
}