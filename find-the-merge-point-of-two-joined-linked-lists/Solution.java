import java.util.Stack;

class Node {
	int data;
	Node next;
}

public class Solution {
	// Complete this function
	// Do not write the main method.
	int FindMergeNode(Node headA, Node headB) {
		Stack<Node> stackA = buildStack(headA);
		Stack<Node> stackB = buildStack(headB);

		Node mergeNode = null;
		while (!stackA.empty() && !stackB.empty()
				&& stackA.peek() == stackB.peek()) {
			mergeNode = stackA.pop();
			stackB.pop();
		}
		return mergeNode.data;
	}

	Stack<Node> buildStack(Node head) {
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		return stack;
	}
}
