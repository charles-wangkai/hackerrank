// The Node class is defined as follows:
class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	boolean checkBST(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean check(Node node, int lower, int upper) {
		if (node == null) {
			return true;
		}
		if (!(node.data >= lower && node.data <= upper)) {
			return false;
		}

		return check(node.left, lower, node.data - 1) && check(node.right, node.data + 1, upper);
	}
}
