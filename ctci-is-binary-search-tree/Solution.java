// Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

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

	boolean check(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
	}
}
