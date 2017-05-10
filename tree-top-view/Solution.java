import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	void top_view(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> leftPath = new Stack<Node>();
		for (Node node = root; node != null; node = node.left) {
			leftPath.push(node);
		}

		StringBuilder sb = new StringBuilder();
		while (!leftPath.empty()) {
			sb.append(leftPath.pop().data + " ");
		}

		for (Node node = root.right; node != null; node = node.right) {
			sb.append(node.data + " ");
		}

		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
